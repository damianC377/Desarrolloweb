import {
  BrowserRouter as Router,
  Routes,
  Route,
  Navigate,
} from "react-router-dom";
import Nav from "./components/Nav";
import Footer from "./components/Footer";

import Home from "./pages/Home";
import About from "./pages/About";
import Services from "./pages/Services";
import Gallery from "./pages/Gallery";
import NewsEvents from "./pages/NewsEvents";
import SignUp from "./pages/SignUp";
import PaymentForm from "./pages/PaymentForm";
import Login from "./pages/Login";
import StudentDashboard from "./pages/StudentDashboard";
import AdminDashboard from "./pages/AdminDasboard";

// Componente de ruta protegida por rol
const ProtectedRoute = ({ children, allowedRoles }) => {
  const token = localStorage.getItem("token");
  if (!token) return <Navigate to="/login" />;

  const payload = JSON.parse(atob(token.split(".")[1]));
  const userRole = payload.role;

  if (!allowedRoles.includes(userRole)) return <Navigate to="/login" />;

  return children;
};

function App() {
  return (
    <Router>
      <Routes>
        {/* Páginas públicas */}
        <Route
          path="/"
          element={
            <>
              <Nav />
              <Home />
              <Footer />
            </>
          }
        />
        <Route
          path="/about"
          element={
            <>
              <Nav />
              <About />
              <Footer />
            </>
          }
        />
        <Route
          path="/services"
          element={
            <>
              <Nav />
              <Services />
              <Footer />
            </>
          }
        />
        <Route
          path="/gallery"
          element={
            <>
              <Nav />
              <Gallery />
              <Footer />
            </>
          }
        />
        <Route
          path="/newsEvents"
          element={
            <>
              <Nav />
              <NewsEvents />
              <Footer />
            </>
          }
        />
        <Route
          path="/signUp"
          element={
            <>
              <Nav />
              <SignUp />
              <Footer />
            </>
          }
        />
        <Route
          path="/payment"
          element={
            <>
              <Nav />
              <PaymentForm />
              <Footer />
            </>
          }
        />

        {/* Login */}
        <Route path="/login" element={<Login />} />

        {/* Dashboards protegidos */}
        <Route
          path="/studentDashboard"
          element={
            <ProtectedRoute allowedRoles={["STUDENT"]}>
              <StudentDashboard />
            </ProtectedRoute>
          }
        />
        <Route
          path="/adminDasboard"
          element={
            <ProtectedRoute allowedRoles={["ADMIN"]}>
              <AdminDashboard />
            </ProtectedRoute>
          }
        />
      </Routes>
    </Router>
  );
}

export default App;
