import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react'

// https://vite.dev/config/
export default defineConfig({
  plugins: [react()],
  server: {
    port: 3000, // React runs on http://localhost:3000
    proxy: {
      "/api": {
        target: "http://localhost:9999", // Spring Boot port
        changeOrigin: true,
        secure: false,
      },
    },
  },
});
