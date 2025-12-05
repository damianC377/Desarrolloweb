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
