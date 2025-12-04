import { useState, useEffect } from "react";
import "./Carousel.css";
import slide1 from "../assets/img/slide1.jpg";
import slide2 from "../assets/img/slide2.jpg";
import slide3 from "../assets/img/slide3.jpg";

export default function Carousel() {
  const slides = [
    {
      image: slide1,
      title: "Aprende a Patinar con Pasión",
      subtitle:
        "Clases para todas las edades y niveles, combinando diversión y técnica en un ambiente confiable",
    },
    {
      image: slide2,
      title: "Instructores Profesionales",
      subtitle:
        "Equipo certificado que te guía con experiencia y entusiasmo para que avances con seguridad",
    },
    {
      image: slide3,
      title: "Instalaciones Modernas",
      subtitle:
        "Espacios diseñados para tu seguridad y comodidad, con equipamiento de calidad",
    },
  ];

  const [current, setCurrent] = useState(0);

  useEffect(() => {
    const timer = setInterval(() => {
      nextSlide();
    }, 4000);
    return () => clearInterval(timer);
  }, [current]);

  const nextSlide = () => {
    setCurrent(current === slides.length - 1 ? 0 : current + 1);
  };

  const prevSlide = () => {
    setCurrent(current === 0 ? slides.length - 1 : current - 1);
  };

  return (
    <div className="carousel">
      {/* Imagenes */}
      {slides.map((slide, index) => (
        <div
          key={index}
          className={index === current ? "slide active" : "slide"}
          style={{ backgroundImage: `url(${slide.image})` }}
        ></div>
      ))}

      <div className="carousel-content">
        <h1>{slides[current].title}</h1>
        <p>{slides[current].subtitle}</p>
      </div>

      <button className="arrow left" onClick={prevSlide}>
        ❮
      </button>
      <button className="arrow right" onClick={nextSlide}>
        ❯
      </button>
    </div>
  );
}
