import { useState, useEffect } from "react";
import "./Carousel.css";

export default function Carousel({ slides, type }) {
  const [current, setCurrent] = useState(0);

  useEffect(() => {
    const timer = setInterval(() => nextSlide(), 4000);
    return () => clearInterval(timer);
  }, [current]);

  const nextSlide = () => setCurrent(current === slides.length - 1 ? 0 : current + 1);
  const prevSlide = () => setCurrent(current === 0 ? slides.length - 1 : current - 1);

  return (
    <div className={`carousel ${type === "testimonial" ? "testimonial-carousel" : ""}`}>
      {slides.map((slide, index) => (
        <div
          key={index}
          className={index === current ? "slide active" : "slide"}
          style={type !== "testimonial" && slide.image ? { backgroundImage: `url(${slide.image})` } : {}}
        >
          <div className={type === "testimonial" ? "testimonial-content" : "carousel-content"}>
            <h3>{slide.title}</h3>
            <p>{slide.subtitle}</p>
          </div>
        </div>
      ))}

      <button className="arrow left" onClick={prevSlide}>❮</button>
      <button className="arrow right" onClick={nextSlide}>❯</button>
    </div>
  );
}

