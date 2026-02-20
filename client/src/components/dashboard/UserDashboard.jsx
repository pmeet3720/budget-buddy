import React, { useEffect, useState } from "react";
import { expenseApi } from "../../apis/index";
import { useNavigate } from "react-router-dom";

export const UserDashboard = () => {
  const user = JSON.parse(localStorage.getItem("user"));
  const [data, setData] = useState([]);
  const [loading, setLoading] = useState(false);
  const navigate = useNavigate();

  useEffect(() => {
    setLoading(true);

    expenseApi
      .get("/expenses") // backend should return ONLY this user's expenses
      .then((res) => {
        setData(res.data["Data"]);
        console.log("data...", res.data["Data"]);

        setLoading(false);
      })
      .catch((err) => {
        console.error(err);
        setLoading(false);
      });
  }, []);

  return (
    <div
      className="container-fluid"
      style={{
        minHeight: "calc(100vh - 80px)",
        paddingTop: "100px",
        background: "linear-gradient(135deg, #e6f4ea, #f3f7f5)",
      }}
    >
      {/* Header */}
      <div className="d-flex justify-content-between align-items-center mb-4 px-4">
        <div>
          <h2 className="fw-bold">Customer Dashboard</h2>
          <p className="text-muted mb-0">{user?.email}</p>
        </div>

        <button
          className="btn btn-success"
          onClick={() => navigate("/add-expense")}
        >
          + Add Expense
        </button>
      </div>

      {/* Content */}
      <div className="container">
        {loading ? (
          <div className="text-center mt-5">
            <div className="spinner-border text-success" />
          </div>
        ) : data.length === 0 ? (
          <div className="text-center mt-5 text-muted">
            <h5>No expenses found</h5>
            <p>Start by adding your first expense</p>
          </div>
        ) : (
          <div className="row g-4">
            {data.map((expense) => (
              <div className="col-md-4" key={expense.id}>
                <div className="card shadow-sm h-100">
                  <div className="card-body">
                    <h2 className="card-title fw-bold">{expense.title}</h2>
                    <h5 className="card-title fw-bold">₹ {expense.amount}</h5>
                    <p className="card-text text-muted mb-1">{expense.note}</p>
                    <small className="text-secondary">
                      Category: {expense.category}
                    </small>
                  </div>

                  <div className="card-footer bg-white border-0 d-flex justify-content-between">
                    <small className="text-muted">
                      {new Date(expense.createdAt).toLocaleDateString()}
                    </small>
                  </div>
                </div>
              </div>
            ))}
          </div>
        )}
      </div>
    </div>
  );
};
