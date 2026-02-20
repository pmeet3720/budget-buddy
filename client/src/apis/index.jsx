import axios from "axios";

export const expenseApi = axios.create({
  baseURL: "/api/expense",
});

export const loginApi = axios.create({
  baseURL: "/api/public",
});

expenseApi.interceptors.request.use((config) => {
  const token = localStorage.getItem("token");
  if (token) {
    config.headers.Authorization = `Bearer ${token}`;
  }
  return config;
});
