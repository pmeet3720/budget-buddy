import axios from "axios";

const expenseApi = axios.create({
  baseURL: "/api/expense", // 👈 important: no localhost here
});

expenseApi.interceptors.request.use((config) => {
  const token = localStorage.getItem("token");
  if (token) {
    config.headers.Authorization = `Bearer ${token}`;
  }
  return config;
});

export default expenseApi;
