import React, { useEffect, useState } from "react";
import expenseApi from "../apis/index";

export const ListExpenses = () => {
  const [data, setData] = useState([]);
  const [loading, setLoading] = useState(false);

  useEffect(() => {
    setLoading(true);

    expenseApi
      .get("/expenses")
      .then((res) => {
        setData(res.data);
        setLoading(false);
      })
      .catch((err) => console.error(err));
  }, []);

  return (
    <div>
      <h1>List of Expenses</h1>
      <div>{loading === true ? "Loading..." : ""}</div>
      <div>
        {data.length === 0 && <p>No data yet</p>}

        {data?.map((exp) => (
          <div
            key={exp.id}
            style={{ border: "1px solid #ccc", margin: "8px", padding: "8px" }}
          >
            <p>
              <b>Title:</b> {exp.title}
            </p>
            <p>
              <b>Note:</b> {exp.note}
            </p>
            <p>
              <b>Amount:</b> ₹{exp.amount}
            </p>
            <p>
              <b>Category:</b> {exp.categoryId}
            </p>
            <p>
              <b>Date:</b> {exp.createdAt}
            </p>
          </div>
        ))}
      </div>
    </div>
  );
};
