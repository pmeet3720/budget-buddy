import React from "react";
import { Link, useLocation, useNavigate } from "react-router-dom";

export const Navbar = () => {
  const location = useLocation();
  const navigate = useNavigate();

  const token = localStorage.getItem("token");
  const user = JSON.parse(localStorage.getItem("user"));

  const isDashboard = location.pathname.startsWith("/userdashboard");

  const handleLogout = () => {
    localStorage.removeItem("token");
    localStorage.removeItem("user");
    navigate("/signin");
  };

  return (
    <div>
      <nav
        className="navbar navbar-expand-lg"
        style={{
          backgroundColor: "#3a4a5a",
          minHeight: "80px",
          padding: "0 20px",
          zIndex: 1000, // keep it above content
        }}
      >
        <div className="container-fluid d-flex align-items-center">
          {/* App Name */}
          <Link className="navbar-brand text-white fw-bold fs-4" to="/">
            Budget Buddy
          </Link>

          {/* Right Side */}
          <div className="ms-auto d-flex align-items-center">
            {token && user ? (
              <>
                {/* Customer Name */}
                <span className="text-white mx-3 fw-semibold">
                  👋 {user.firstName || user.email}
                </span>

                {/* Logout */}
                <button
                  onClick={handleLogout}
                  className="btn btn-outline-light btn-sm"
                >
                  Logout
                </button>
              </>
            ) : (
              <>
                <Link className="nav-link text-white mx-2" to="/about">
                  About
                </Link>
                <Link className="nav-link text-white mx-2" to="/signin">
                  Sign In
                </Link>
                <Link className="btn btn-outline-light ms-2" to="/signup">
                  Sign Up
                </Link>
              </>
            )}
          </div>
        </div>
      </nav>
    </div>
  );
};
