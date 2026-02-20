import React, { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import { loginApi } from "../../apis/index";

export const SignIn = () => {
  const navigate = useNavigate()
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [error, setError] = useState("");

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      const res = await loginApi.post("/login", {
        email,
        password,
      });

      // token received from backend
      const token = res.data.token;

      localStorage.setItem("token", token)
      localStorage.setItem("user", JSON.stringify(res.data.user))
      
      navigate("/userdashboard")

    } catch (err) {
      setError("Invalid email or password");
    }
  };

  return (
    <div
      className="container-fluid d-flex justify-content-center align-items-center"
      style={{
        minHeight: "calc(100vh - 80px)",
        background: "linear-gradient(135deg, #e6f4ea, #f3f7f5)",
      }}
    >
      <div
        className="card shadow-lg p-4"
        style={{ maxWidth: "420px", width: "100%", borderRadius: "12px" }}
      >
        {/* Header */}
        <div className="text-center mb-4">
          <h2 className="fw-bold">Sign In</h2>
          <p className="text-muted mb-0">
            Don’t have an account?{" "}
            <Link
              to="/signup"
              style={{
                color: "#0d6efd", // Bootstrap primary blue
                textDecoration: "underline",
                fontWeight: "600",
              }}
            >
              Sign up
            </Link>
          </p>
        </div>

        {error && <div className="alert alert-danger py-2">{error}</div>}

        {/* Form */}
        <form onSubmit={handleSubmit}>
          <div className="mb-3">
            <input
              type="email"
              className="form-control"
              placeholder="Email"
              value={email}
              onChange={(e) => {
                setEmail(e.target.value);
              }}
            />
          </div>

          <div className="mb-2">
            <input
              type="password"
              className="form-control"
              placeholder="Password"
              value={password}
              onChange={(e) => {
                setPassword(e.target.value);
              }}
            />
          </div>

          {/* Forgot password */}
          <div className="text-end mb-3">
            <Link
              to="/forgot-password"
              className="text-decoration-none small"
              style={{ color: "#3a4a5a" }}
            >
              Forgot password?
            </Link>
          </div>

          {/* Button */}
          <button
            type="submit"
            className="btn w-100 py-2 fw-semibold text-white"
            style={{ backgroundColor: "#3a4a5a" }} // ✅ same as navbar
          >
            Login
          </button>
        </form>
      </div>
    </div>
  );
};
