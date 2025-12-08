import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
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
import StudentDashboard from "./pages/StudentDasboard";
import AdminDashboard from "./pages/AdminDasboard";

function App() {
  return (
    <Router>
      <Routes>
        {/* Páginas públicas con Nav y Footer */}
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

        <Route path="/login" element={<Login />} />
        <Route path="/studentDasboard" element={<StudentDashboard />} />
        <Route path="/adminDasboard" element={<AdminDashboard />} />
      </Routes>
    </Router>
  );
}

export default App;
