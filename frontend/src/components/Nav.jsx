import "./Nav.css";
import { Link } from "react-router-dom";
import skateIcon from "../assets/icons/skate.png";

export default function Nav() {
  return (
    <nav className="navbar">
      <ul className="navList">
        <li className="logo">
          {/* <img src={skateIcon} alt="Skate Icon" className="logo-icon" /> */}
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
            <Link to="/NewsEvents">Noticias y Testimonios</Link>
          </li>
        </div>
      </ul>
    </nav>
  );
}
