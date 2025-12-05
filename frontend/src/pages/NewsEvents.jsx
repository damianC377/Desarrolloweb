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
      type: "aviso",
      date: "2024-12-10",
      dateDisplay: "10 Dic 2024",
      title: "Cierre de Inscripciones Curso de Verano 2025",
      description:
        "Recordamos que las inscripciones para el curso intensivo de verano cierran el 20 de diciembre.",
      details:
        "Últimos cupos disponibles en los horarios de mañana. No te quedes sin tu lugar. Descuentos especiales por pago anticipado.",
      location: null,
    },
    {
      type: "resultado",
      date: "2024-12-05",
      dateDisplay: "05 Dic 2024",
      title: "¡Resultados Destacados en Torneo Nacional!",
      description:
        "Nuestros estudiantes brillaron en el Torneo Nacional obteniendo excelentes resultados que nos llenan de orgullo.",
      details:
        "3 medallas de oro, 5 de plata y 4 de bronce. Destacada participación de todos nuestros representantes. Felicitaciones a estudiantes, padres e instructores.",
      location: "Bogotá, Colombia",
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
      type: "aviso",
      date: "2024-11-28",
      dateDisplay: "28 Nov 2024",
      title: "Mantenimiento de Instalaciones",
      description:
        "La pista principal estará cerrada temporalmente por trabajos de mantenimiento y mejora.",
      details:
        "Fecha: del 5 al 7 de diciembre. Las clases continuarán normalmente en la pista auxiliar. Disculpen las molestias.",
      location: null,
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
      type: "resultado",
      date: "2024-11-20",
      dateDisplay: "20 Nov 2024",
      title: "Clasificación a Campeonato Sudamericano",
      description:
        "¡Tres de nuestros estudiantes clasificaron al Campeonato Sudamericano de Patinaje 2025!",
      details:
        "Ana Morales, Luis Pérez y Sofía Hernández representarán a Colombia en Chile. Una hazaña histórica para nuestra escuela.",
      location: "Clasificatorio en Medellín",
    },
    {
      type: "aviso",
      date: "2024-12-01",
      dateDisplay: "01 Dic 2024",
      title: "Nuevos Horarios Disponibles",
      description:
        "Por alta demanda, abrimos nuevos horarios para clases grupales en enero 2025.",
      details:
        "Nuevos grupos: Lunes y miércoles 3:00 PM, Martes y jueves 5:00 PM. Información detallada en recepción.",
      location: null,
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

  const filters = [
    { id: "all", name: "Todas" },
    { id: "evento", name: "Próximos Eventos" },
    { id: "aviso", name: "Avisos" },
    { id: "resultado", name: "Resultados" },
  ];

  const filteredNews =
    selectedFilter === "all"
      ? news
      : news.filter((item) => item.type === selectedFilter);

  const sortedNews = [...filteredNews].sort(
    (a, b) => new Date(b.date) - new Date(a.date)
  );

  return (
    <div className="news-page">
      <div className="news-container">
        <h2 className="news-page-title">Noticias y Eventos</h2>
        <p className="news-description">
          Mantente informado sobre nuestras próximas actividades, avisos
          importantes y los logros más recientes de nuestra comunidad.
        </p>

        {/* Filtros */}
        <div className="news-filters">
          {filters.map((filter) => (
            <button
              key={filter.id}
              className={`filter-btn ${
                selectedFilter === filter.id ? "active" : ""
              }`}
              onClick={() => setSelectedFilter(filter.id)}
            >
              {filter.name}
            </button>
          ))}
        </div>

        <div className="news-grid">
          {sortedNews.map((item, index) => (
            <div key={index} className={`news-card ${item.type}`}>
              <div className="news-badge">{item.type}</div>
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
        <div className="upcoming-events">
          <h3 className="subsection-title">Calendario de Próximos Eventos</h3>
          <div className="calendar-list">
            {news
              .filter(
                (item) =>
                  item.type === "evento" && new Date(item.date) >= new Date()
              )
              .sort((a, b) => new Date(a.date) - new Date(b.date))
              .map((event, index) => (
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
        </div>
      </div>
    </div>
  );
}

export default NewsEvents;
