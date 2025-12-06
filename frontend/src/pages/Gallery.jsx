import { useState } from "react";
import "./Gallery.css";

// Importa las imágenes
import gallery1 from "../assets/img/gallery1.jpg";
import gallery2 from "../assets/img/gallery2.jpg";
import gallery3 from "../assets/img/gallery3.jpg";
import gallery4 from "../assets/img/gallery4.jpg";
import gallery5 from "../assets/img/gallery5.jpg";
import gallery6 from "../assets/img/gallery6.jpg";

const Gallery = () => {
  const [selectedCategory, setSelectedCategory] = useState("all");

  const galleryItems = [
    {
      type: "image",
      category: "training",
      src: gallery1,
      alt: "Entrenamiento Grupal Nivel Intermedio",
    },
    {
      type: "image",
      category: "competition",
      src: gallery2,
      alt: "Campeonato Regional 2023 - Podio",
    },
    {
      type: "image",
      category: "training",
      src: gallery3,
      alt: "Clase de Principiantes - Primeros Pasos",
    },
    {
      type: "image",
      category: "events",
      src: gallery4,
      alt: "Show Anual 2023 - Presentación Artística",
    },
    {
      type: "image",
      category: "events",
      src: gallery5,
      alt: "Ceremonia de Graduación de Nivel",
    },
    {
      type: "image",
      category: "facilities",
      src: gallery6,
      alt: "Nuestras Instalaciones - Pista Principal",
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
            <div key={index} className="gallery-item">
              <img src={item.src} alt={item.alt} className="gallery-img" />
              <div className="gallery-text">
                <span>{item.alt}</span>
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
