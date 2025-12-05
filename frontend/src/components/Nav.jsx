import "./Nav.css";
import { Link } from "react-router-dom";
import { Zap } from "lucide-react";

export default function Nav() {
  return (
    <nav className="navbar">
      <ul className="navList">
        <li className="logo">
          <Zap size={28} color="var(--accent)" style={{ marginRight: "0.5rem" }} />
          Rolling Speed
        </li>

        <div className="menu">
          <li>
            <Link to="/">Inicio</Link>
          </li>
          <li>
            <Link to="/about">Quienes somos</Link>
          </li>
          <li>
            <Link to="/services">Servicios</Link>
          </li>
          <li>
            <Link to="/gallery">Galería</Link>
          </li>
          <li>
            <Link to="/newsEvents">Noticias y Testimonios</Link>
          </li>
          <li>
            <Link to="/signUp">Inscripción</Link>
          </li>
        </div>
      </ul>
    </nav>
  );
}