import { useState } from "react";
import { Calendar } from "lucide-react";
import "./NewsEvents.css";

function NewsEvents() {
  const [selectedFilter, setSelectedFilter] = useState("all");

  const news = [
    {
      type: "evento",
      date: "2024-12-15",
      dateDisplay: "15 Dic 2024",
      title: "Campeonato Regional de Patinaje",
      description:
        "Nuestra escuela participará en el Campeonato Regional con una delegación de 25 estudiantes. El evento se realizará en el Coliseo Municipal.",
      details:
        "Horario: 9:00 AM - 5:00 PM. Entrada libre para el público. Apoyemos a nuestros representantes.",
      location: "Coliseo Municipal",
    },
    {
      type: "evento",
      date: "2024-12-20",
      dateDisplay: "20 Dic 2024",
      title: "Clausura y Ceremonia de Premiación",
      description:
        "Ceremonia especial de fin de año donde celebraremos los logros de todos nuestros estudiantes y entregaremos certificados de nivel.",
      details:
        "Evento familiar. Se solicita confirmar asistencia. Habrá presentaciones especiales de nuestros grupos de patinaje artístico.",
      location: "Instalaciones de la escuela",
    },
    {
      type: "evento",
      date: "2025-01-08",
      dateDisplay: "08 Ene 2025",
      title: "Inicio de Clases 2025",
      description:
        "Comenzamos el año 2025 con energía renovada y nuevos programas de entrenamiento.",
      details:
        "Primer día de clases: 8 de enero. Horarios y grupos disponibles en recepción. Bienvenidos nuevos estudiantes.",
      location: "Instalaciones de la escuela",
    },
    {
      type: "evento",
      date: "2025-01-15",
      dateDisplay: "15 Ene 2025",
      title: "Taller Especial: Técnicas de Salto",
      description:
        "Taller especializado con instructor invitado internacional sobre técnicas avanzadas de salto.",
      details:
        "Cupos limitados. Nivel intermedio-avanzado. Incluye certificado de participación. Inscripciones abiertas.",
      location: "Instalaciones de la escuela",
    },
    {
      type: "evento",
      date: "2025-02-14",
      dateDisplay: "14 Feb 2025",
      title: "Evento Especial: Día del Amor y la Amistad",
      description:
        "Jornada recreativa especial con actividades, juegos y patinaje libre para toda la familia.",
      details:
        "Actividades desde las 2:00 PM. Entrada libre para familiares. Habrá rifas y sorpresas.",
      location: "Instalaciones de la escuela",
    },
  ];

  // Filtramos solo eventos
  const filteredNews = news.filter((item) => item.type === "evento");

  // Ordenamos por fecha de manera ascendente (próximos eventos primero)
  const sortedNews = [...filteredNews].sort(
    (a, b) => new Date(a.date) - new Date(b.date)
  );

  return (
    <div className="news-page">
      <div className="news-container">
        <h2 className="news-page-title">Próximos Eventos</h2>
        <p className="news-description">
          Mantente informado sobre nuestras próximas actividades y eventos
          especiales de la escuela.
        </p>

        <div className="news-grid">
          {sortedNews.map((item, index) => (
            <div key={index} className="news-card evento">
              <div className="news-date">
                <Calendar size={16} />
                {item.dateDisplay}
              </div>
              {item.location && (
                <div className="news-location">📍 {item.location}</div>
              )}
              <h3>{item.title}</h3>
              <p className="news-description-text">{item.description}</p>
              <p className="news-details">{item.details}</p>
            </div>
          ))}
        </div>

        {/* Calendario de próximos eventos */}
        {/* <div className="upcoming-events">
          <h3 className="subsection-title">Calendario de Próximos Eventos</h3>
          <div className="calendar-list">
            {sortedNews.map((event, index) => (
              <div key={index} className="calendar-item">
                <div className="calendar-date">
                  <div className="date-day">
                    {new Date(event.date).getDate()}
                  </div>
                  <div className="date-month">
                    {new Date(event.date).toLocaleDateString("es-ES", {
                      month: "short",
                    })}
                  </div>
                </div>
                <div className="calendar-info">
                  <h4>{event.title}</h4>
                  <p>{event.description}</p>
                </div>
              </div>
            ))}
          </div>
        </div> */}
      </div>
    </div>
  );
}

export default NewsEvents;
