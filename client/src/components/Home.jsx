import React from "react";
import heroImg from "../assets/expenseuser.png";

export const Home = () => {
  return (
    <div
      className="container-fluid d-flex justify-content-center align-items-center"
      style={{
        minHeight: "calc(100vh - 80px)",
        paddingTop: "80px",
        background: "linear-gradient(135deg, #e6f4ea, #f3f7f5)",
      }}
    >
      <div className="text-center px-1">
        {/* Image */}
        <img
          src={heroImg}
          alt="Expense Tracker"
          className="img-fluid mb-4"
          style={{ maxHeight: "300px" }}
        />

        {/* Text */}
        <h1 className="fw-bold display-5 text-dark">
          Expense Tracker Application
        </h1>

        <p className="lead text-muted mt-3">
          Track your expenses, control your budget, and build better financial
          habits.
        </p>

        {/* Buttons */}
        <div className="mt-4">
          <button className="btn btn-success btn-lg mx-3 px-4">
            Get Started
          </button>
          <button className="btn btn-outline-success btn-lg px-4">
            Learn More
          </button>
        </div>
      </div>
    </div>
  );
};
