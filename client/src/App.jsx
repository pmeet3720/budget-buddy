import { useState } from "react";
import { Route, Routes } from "react-router-dom";
import { Navbar } from "./components/Navbar";
import { Home } from "./components/Home";
import { ListExpenses } from "./components/expense/ListExpenses";
import "./App.css";
import { SignIn } from "./components/auth/SignIn";
import { UserDashboard } from "./components/dashboard/UserDashboard";
import { PrivateRoute } from "./components/PrivateRoute";

function App() {
  return (
    <div>
      <Navbar />
      <div className="">
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/signin" element={<SignIn />} />
          <Route
            path="/userdashboard"
            element={
              <PrivateRoute>
                <UserDashboard />
              </PrivateRoute>
            }
          />
          <Route path="/listexpenses" element={<ListExpenses />} />
        </Routes>
      </div>
    </div>
  );
}

export default App;
