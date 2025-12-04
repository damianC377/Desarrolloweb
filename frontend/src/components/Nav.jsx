import "./Nav.css";
import { Link } from "react-router-dom";
import skateIcon from "../assets/icons/skate.png";

export default function Nav() {
  return (
    <nav className="navbar">
      <ul className="navList">
        <li className="logo">
          {/* <img src={skateIcon} alt="Skate Icon" className="logo-icon" /> */}
          Rolling skate
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
            <Link to="/contact">Contacto</Link>
          </li>
        </div>
      </ul>
    </nav>
  );
}
