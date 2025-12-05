import { useState } from "react";
import { Play } from "lucide-react";
import "./Gallery.css";

const Gallery = () => {
  const [selectedCategory, setSelectedCategory] = useState("all");

  const galleryItems = [
    {
      type: "image",
      category: "training",
      placeholder: "Entrenamiento Grupal Nivel Intermedio",
    },
    {
      type: "image",
      category: "competition",
      placeholder: "Campeonato Regional 2023 - Podio",
    },
    {
      type: "image",
      category: "training",
      placeholder: "Clase de Principiantes - Primeros Pasos",
    },
    {
      type: "image",
      category: "events",
      placeholder: "Show Anual 2023 - Presentación Artística",
    },
    {
      type: "video",
      category: "competition",
      placeholder: "VIDEO: Rutina de Campeones Nacionales",
    },
    {
      type: "image",
      category: "facilities",
      placeholder: "Nuestras Instalaciones - Pista Principal",
    },
    {
      type: "image",
      category: "events",
      placeholder: "Ceremonia de Graduación de Nivel",
    },
    {
      type: "video",
      category: "events",
      placeholder: "VIDEO: Día de las Familias 2023",
    },
    {
      type: "image",
      category: "training",
      placeholder: "Taller de Verano Intensivo",
    },
    {
      type: "image",
      category: "competition",
      placeholder: "Competencia Nacional - Categoría Juvenil",
    },
    {
      type: "image",
      category: "training",
      placeholder: "Entrenamiento de Hockey sobre Patines",
    },
    {
      type: "video",
      category: "training",
      placeholder: "VIDEO: Técnicas de Patinaje Artístico",
    },
    {
      type: "image",
      category: "facilities",
      placeholder: "Sala de Espera y Cafetería",
    },
    {
      type: "image",
      category: "events",
      placeholder: "Celebración Día del Niño",
    },
    {
      type: "image",
      category: "competition",
      placeholder: "Medallas y Trofeos 2023",
    },
    {
      type: "video",
      category: "events",
      placeholder: "VIDEO: Resumen Anual 2023",
    },
    {
      type: "image",
      category: "training",
      placeholder: "Clase Individual - Corrección Técnica",
    },
    {
      type: "image",
      category: "facilities",
      placeholder: "Vestuarios y Zona de Preparación",
    },
  ];

  const categories = [
    { id: "all", name: "Todo" },
    { id: "training", name: "Entrenamientos" },
    { id: "competition", name: "Competencias" },
    { id: "events", name: "Eventos" },
    { id: "facilities", name: "Instalaciones" },
  ];

  const filteredItems =
    selectedCategory === "all"
      ? galleryItems
      : galleryItems.filter((item) => item.category === selectedCategory);

  return (
    <div className="gallery-page">
      <div className="gallery-container">
        <h2 className="gallery-title">Galería</h2>
        <p className="gallery-description">
          Revive los mejores momentos de entrenamientos, eventos, competencias y
          logros de nuestra comunidad.
        </p>

        <div className="gallery-filters">
          {categories.map((category) => (
            <button
              key={category.id}
              className={`filter-btn ${
                selectedCategory === category.id ? "active" : ""
              }`}
              onClick={() => setSelectedCategory(category.id)}
            >
              {category.name}
            </button>
          ))}
        </div>

        <div className="gallery-grid">
          {filteredItems.map((item, index) => (
            <div key={index} className={`gallery-item ${item.type}`}>
              <div className="gallery-placeholder">
                {item.type === "video" && (
                  <div className="video-icon">
                    <Play size={48} />
                  </div>
                )}
                <span>{item.placeholder}</span>
              </div>
              <div className="gallery-overlay">
                <button className="view-btn">Ver completo</button>
              </div>
            </div>
          ))}
        </div>
      </div>
    </div>
  );
};

export default Gallery;
