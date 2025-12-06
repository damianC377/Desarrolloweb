import { Users, Award } from "lucide-react";
import "./About.css";

import about1 from "../assets/img/about1.jpg";
import about2 from "../assets/img/about2.jpg";
import about3 from "../assets/img/about3.jpg";

function About() {
  return (
    <div className="about-page">
      <div className="about-container">
        <h2 className="about-title">Quiénes Somos</h2>

        {/* Nuestra Historia */}
        <section className="about-section">
          <div className="about-text">
            <h3>Nuestra Historia</h3>
            <p>
              Fundada en 2010, nuestra escuela nació del sueño de un grupo de
              patinadores profesionales que querían crear un espacio donde
              niños, jóvenes y adultos pudieran descubrir y desarrollar su
              pasión por el patinaje. Comenzamos con un pequeño grupo de 15
              estudiantes entusiastas en una modesta pista alquilada, pero con
              una visión clara de lo que queríamos lograr.
            </p>
            <p>
              A lo largo de estos 14 años, hemos crecido exponencialmente, no
              solo en número de estudiantes, sino en la calidad de nuestros
              programas y el reconocimiento de la comunidad deportiva. Hoy
              contamos con instalaciones propias de primer nivel, un equipo de
              instructores certificados internacionalmente y una comunidad de
              más de 500 estudiantes activos.
            </p>
          </div>
          <div className="about-image">
            <div className="image-placeholder">
              <img src={about1} alt="Personas patinando" />
            </div>
          </div>
        </section>

        {/* Nuestro Propósito */}
        <section className="about-section reverse">
          <div className="about-image">
            <img src={about2} alt="Nuestro equipo" />
          </div>
          <div className="about-text">
            <h3>Nuestro Propósito</h3>
            <p>
              Más allá de enseñar técnicas de patinaje, nuestro propósito es
              formar personas íntegras que lleven consigo los valores del
              deporte a todos los aspectos de su vida. Creemos firmemente en el
              poder transformador del patinaje para desarrollar confianza,
              perseverancia, disciplina y trabajo en equipo.
            </p>
            <p>
              Nos comprometemos a ofrecer un ambiente inclusivo donde cada
              estudiante, independientemente de su edad, nivel o capacidad, se
              sienta valorado, respetado y motivado a alcanzar su máximo
              potencial. Queremos que cada persona que pase por nuestra escuela
              no solo aprenda a patinar, sino que descubra lo mejor de sí misma.
            </p>
          </div>
        </section>

        {/* Nuestros Logros */}
        <section className="achievements-section">
          <h3>Nuestros Logros</h3>
          <div className="achievements-grid">
            <div className="achievement-item">
              <div className="achievement-icon">🏆</div>
              <div className="achievement-text">
                <strong>+60 Medallas</strong>
                <span>En campeonatos nacionales</span>
              </div>
            </div>
            <div className="achievement-item">
              <div className="achievement-icon">🥇</div>
              <div className="achievement-text">
                <strong>18 Clasificados</strong>
                <span>A competencias internacionales</span>
              </div>
            </div>
            <div className="achievement-item">
              <div className="achievement-icon">⭐</div>
              <div className="achievement-text">
                <strong>Mejor Escuela</strong>
                <span>Premio regional 2022-2023</span>
              </div>
            </div>
            <div className="achievement-item">
              <div className="achievement-icon">👥</div>
              <div className="achievement-text">
                <strong>+500 Estudiantes</strong>
                <span>Formados exitosamente</span>
              </div>
            </div>
            <div className="achievement-item">
              <div className="achievement-icon">🎓</div>
              <div className="achievement-text">
                <strong>Certificación</strong>
                <span>Programas avalados nacionalmente</span>
              </div>
            </div>
            <div className="achievement-item">
              <div className="achievement-icon">🌟</div>
              <div className="achievement-text">
                <strong>Alianzas</strong>
                <span>Con federaciones deportivas</span>
              </div>
            </div>
          </div>
        </section>

        {/* Nuestro Equipo */}
        <section className="about-section">
          <div className="about-text">
            <h3>Nuestro Equipo</h3>
            <p>
              Contamos con un equipo de 10 instructores certificados,
              apasionados y con amplia experiencia tanto en la enseñanza como en
              la competencia. Cada miembro de nuestro equipo está comprometido
              con la excelencia y el desarrollo integral de nuestros
              estudiantes.
            </p>
            <p>
              Nuestros instructores se actualizan constantemente a través de
              seminarios, certificaciones internacionales y participación en
              congresos deportivos. Además, varios de ellos han sido patinadores
              competitivos de alto nivel, lo que les permite transmitir
              experiencias reales y técnicas probadas.
            </p>
            <div className="team-stats">
              <div className="stat">
                <Users size={40} />
                <span className="stat-number">10</span>
                <span className="stat-label">Instructores certificados</span>
              </div>
              <div className="stat">
                <Award size={40} />
                <span className="stat-number">15+</span>
                <span className="stat-label">Años de experiencia promedio</span>
              </div>
            </div>
          </div>
          <div className="about-image">
            <img src={about3} alt="Instalaciones" />
          </div>
        </section>
      </div>
    </div>
  );
}

export default About;
