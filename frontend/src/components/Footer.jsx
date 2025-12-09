import "./Footer.css";
import { Zap } from "lucide-react";
import { Link } from "react-router-dom";

function Footer() {
  const goTop = () => window.scrollTo(0, 0);

  return (
    <footer className="footer">
      <div className="footer-logo">
        <Zap size={28} color="var(--accent)" />
        <span>Rolling Speed</span>
      </div>

      <div className="footer-sections">
        <div className="footer-section">
          <h3>Sobre Nosotros</h3>
          <p>
            Escuela de patinaje en Santa Marta dedicada a enseñar con pasión y
            profesionalismo. Formamos patinadores de todos los niveles en un
            ambiente seguro y motivador.
          </p>
        </div>

        <div className="footer-section">
          <h3>Navegación</h3>
          <ul>
            <li>
              <Link to="/" onClick={goTop}>
                Inicio
              </Link>
            </li>
            <li>
              <Link to="/about" onClick={goTop}>
                Quiénes Somos
              </Link>
            </li>
            <li>
              <Link to="/services" onClick={goTop}>
                Servicios
              </Link>
            </li>
            <li>
              <Link to="/newsEvents" onClick={goTop}>
                Eventos
              </Link>
            </li>
            <li>
              <Link to="/gallery" onClick={goTop}>
                Galería
              </Link>
            </li>
            <li>
              <Link to="/signUp" onClick={goTop}>
                Inscripción
              </Link>
            </li>
          </ul>
        </div>

        <div className="footer-section">
          <h3>Horarios</h3>
          <p>Lunes a Viernes: 3:00 PM - 8:00 PM</p>
          <p>Sábados: 9:00 AM - 6:00 PM</p>
          <p>Domingos: 10:00 AM - 2:00 PM</p>
        </div>

        <div className="footer-section">
          <h3>Contacto</h3>
          <p>📍 Santa Marta, Colombia</p>
          <p>📧 info@rollerspeed.com</p>
          <p>📱 +57 300 1234567</p>
          <p>💬 WhatsApp: +57 300 7654321</p>
        </div>

        <div className="footer-section">
          <h3>Síguenos</h3>
          <p>Facebook: @RollerSpeed</p>
          <p>Instagram: @rollerspeed_co</p>
          <p>TikTok: @rollerspeed</p>
        </div>
      </div>

      <div className="footer-bottom">
        &copy; {new Date().getFullYear()} Roller Speed. Todos los derechos
        reservados.
      </div>
    </footer>
  );
}

export default Footer;
