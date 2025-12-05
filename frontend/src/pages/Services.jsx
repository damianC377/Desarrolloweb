import "./Services.css";
import { Clock, Users, Target } from "lucide-react";

function Services() {
  const services = [
    {
      id: 1,
      title: "Clases para Principiantes",
      description:
        "Aprende las bases del patinaje: equilibrio, frenado y postura correcta con instructores certificados.",
      details:
        "Grupos reducidos de máximo 10 estudiantes. Material y equipo de protección disponibles.",
      schedule: "Lunes a Viernes: 3:00 PM - 5:00 PM",
      duration: "2 meses",
      ages: "6 años en adelante",
    },
    {
      id: 2,
      title: "Entrenamiento Intermedio",
      description:
        "Perfecciona técnica y velocidad con ejercicios avanzados y rutinas personalizadas.",
      details:
        "Evaluación mensual del progreso individual y sesiones de resistencia y coordinación.",
      schedule: "Martes y Jueves: 5:00 PM - 7:00 PM",
      duration: "3 meses",
      ages: "10 años en adelante",
    },
    {
      id: 3,
      title: "Preparación para Competencias",
      description:
        "Entrenamiento intensivo para competencias con técnica avanzada y preparación física.",
      details:
        "Incluye simulacros, plan nutricional y acompañamiento psicológico deportivo.",
      schedule: "Lunes a Sábado: 6:00 AM - 8:00 AM",
      duration: "6 meses",
      ages: "12 años en adelante",
    },
    {
      id: 4,
      title: "Clases Personalizadas",
      description:
        "Entrenamiento 1:1 adaptado a tus objetivos y nivel, con plan exclusivo y seguimiento.",
      details:
        "Instructor dedicado y horarios flexibles para un progreso óptimo.",
      schedule: "Horarios a convenir",
      duration: "Flexible",
      ages: "Todas las edades",
    },
    {
      id: 5,
      title: "Patinaje Artístico",
      description:
        "Aprende coreografías, saltos y movimientos artísticos sobre patines.",
      details: "Presentaciones en eventos con música y vestuario incluidos.",
      schedule: "Miércoles y Viernes: 4:00 PM - 6:00 PM",
      duration: "4 meses",
      ages: "8 años en adelante",
    },
    {
      id: 6,
      title: "Programas para Niños",
      description:
        "Actividades recreativas para desarrollar coordinación, motricidad y confianza.",
      details:
        "Grupos organizados por edades, con metodología lúdica y divertida.",
      schedule: "Sábados y Domingos: 9:00 AM - 11:00 AM",
      duration: "Programa mensual",
      ages: "4 a 12 años",
    },
  ];

  return (
    <div className="services-complete-page">
      <div className="services-complete-container">
        <div className="services-header">
          <h1 className="services-main-title">Nuestros Servicios</h1>
          <p className="services-main-description">
            Programas de patinaje para cada nivel y edad. Instructores
            certificados, instalaciones modernas y metodología probada.
          </p>
        </div>

        {services.map((service, index) => {
          const isReverse = index % 2 !== 0;

          return (
            <section
              key={service.id}
              className={`service-section ${isReverse ? "reverse" : ""}`}
            >
              <div className="service-text">
                <h2>{service.title}</h2>
                <p className="service-main-desc">{service.description}</p>
                <p className="service-secondary-desc">{service.details}</p>

                <div className="service-meta">
                  <div className="meta-item">
                    <Clock size={18} />
                    <div>
                      <strong>Horario:</strong> {service.schedule}
                    </div>
                  </div>
                  <div className="meta-item">
                    <Users size={18} />
                    <div>
                      <strong>Edades:</strong> {service.ages}
                    </div>
                  </div>
                  <div className="meta-item">
                    <Target size={18} />
                    <div>
                      <strong>Duración:</strong> {service.duration}
                    </div>
                  </div>
                </div>
              </div>
            </section>
          );
        })}

        <div className="services-cta-section">
          <h2>¿Listo para comenzar tu aventura sobre ruedas?</h2>
          <p>
            Contáctanos para más información sobre nuestros programas, horarios
            y descubre nuestras noticias y testimonios.
          </p>
          <div className="cta-buttons">
            <a href="/about" className="btn-primary">
              Quiénes Somos
            </a>
            <a href="/newsEvents" className="btn-secondary">
              Noticias y Eventos
            </a>
          </div>
        </div>
      </div>
    </div>
  );
}

export default Services;
