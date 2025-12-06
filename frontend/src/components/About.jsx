import React from "react";

const AboutPage = () => {
  return (
    <section className="about-page">
      <div className="about-container">
        <h2 className="about-title">Quiénes Somos</h2>

        {/* Sección 1 */}
        <div className="about-section">
          <div className="about-text">
            <h3>Nuestra Historia</h3>
            <p>
              Fundada en 2010, nuestra escuela nació del sueño de un grupo de
              patinadores profesionales que querían crear un espacio donde
              niños, jóvenes y adultos pudieran descubrir y desarrollar su
              pasión por el patinaje.
            </p>
            <p>
              Hoy contamos con instalaciones propias de primer nivel, un equipo
              de instructores certificados internacionalmente y más de 500
              estudiantes activos.
            </p>
          </div>

          <div className="about-image">
            <img
              src="/images/about1.jpg"
              alt="Nuestra historia"
              className="image-placeholder"
            />
          </div>
        </div>

        {/* Sección 2 - Cambia orden con reverse */}
        <div className="about-section reverse">
          <div className="about-text">
            <h3>Nuestro Propósito</h3>
            <p>
              Más allá de enseñar técnicas, formamos personas íntegras que
              llevan valores del deporte a su vida.
            </p>
            <p>
              Creamos un ambiente inclusivo donde cada estudiante se siente
              valorado y motivado a alcanzar su máximo potencial.
            </p>
          </div>

          <div className="about-image">
            <img
              src="/images/about2.jpg"
              alt="Nuestro propósito"
              className="image-placeholder"
            />
          </div>
        </div>

        {/* Sección 3 - Logros */}
        <div className="about-section">
          <div className="about-text">
            <h3>Nuestros Logros</h3>
            <ul style={{ lineHeight: "1.8", fontSize: "1.05rem" }}>
              <li>+60 medallas nacionales</li>
              <li>18 clasificados a competencias internacionales</li>
              <li>Premio Mejor Escuela 2022 – 2023</li>
              <li>+500 estudiantes formados</li>
              <li>Programas certificados</li>
              <li>Alianzas con federaciones deportivas</li>
            </ul>
          </div>

          <div className="about-image">
            <img
              src="/images/about3.jpg"
              alt="Nuestros logros"
              className="image-placeholder"
            />
          </div>
        </div>

        {/* Sección 4 Equipo */}
        <div className="about-section reverse">
          <div className="about-text">
            <h3>Nuestro Equipo</h3>
            <p>
              Contamos con un equipo de 10 instructores certificados,
              apasionados y con amplia experiencia competitiva y pedagógica.
            </p>
            <p>
              Se actualizan mediante certificaciones internacionales, congresos
              y participación activa en el deporte.
            </p>

            <div className="team-stats">
              <div className="stat">
                <span className="stat-number">10</span>
                <span className="stat-label">Instructores certificados</span>
              </div>

              <div className="stat">
                <span className="stat-number">15+</span>
                <span className="stat-label">Años de experiencia promedio</span>
              </div>
            </div>
          </div>

          <div className="about-image">
            <img
              src="/images/about4.jpg"
              alt="Nuestro equipo"
              className="image-placeholder"
            />
          </div>
        </div>
      </div>
    </section>
  );
};

export default AboutPage;
