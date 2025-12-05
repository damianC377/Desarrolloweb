import "./Footer.css";
import { Activity } from "lucide-react";

function Footer() {
  return (
    <footer className="footer">
      <div className="footer-brand">Roller Speed</div>
      

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
            <li>Inicio</li>
            <li>Quiénes Somos</li>
            <li>Servicios</li>
            <li>Horarios</li>
            <li>Galería</li>
            <li>Contacto</li>
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
import "./Footer.css";

function Footer() {
  return (
    <footer className="footer">
      <div className="footer-brand">Rolling Skate</div>

      <div className="footer-sections">
        <div className="footer-section">
          <h3>Navegación</h3>
          <ul>
            <li>Inicio</li>
            <li>Quienes somos</li>
            <li>Servicios</li>
            <li>Contacto</li>
          </ul>
        </div>

        <div className="footer-section">
          <h3>Dirección</h3>
          <p>Calle 123, Medellín, Colombia</p>
        </div>

        <div className="footer-section">
          <h3>Contacto</h3>
          <p>Email: info@rollingskate.com</p>
          <p>Tel: +57 300 1234567</p>
        </div>
      </div>

      <div className="footer-bottom">
        &copy; {new Date().getFullYear()} Rolling Skate. Todos los derechos
        reservados.
      </div>
    </footer>
  );
}

export default Footer;
