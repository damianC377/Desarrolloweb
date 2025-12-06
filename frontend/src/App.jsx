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

function App() {
  return (
    <Router>
      <Nav />
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/about" element={<About />} />
        <Route path="/services" element={<Services />} />
        <Route path="/gallery" element={<Gallery />} />
        <Route path="/newsEvents" element={<NewsEvents />} />
        <Route path="/signUp" element={<SignUp />} />
        <Route path="/payment" element={<PaymentForm />} />
      </Routes>
      <Footer />
    </Router>
  );
}

export default App;
