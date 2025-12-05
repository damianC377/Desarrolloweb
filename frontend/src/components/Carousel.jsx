import { useState, useEffect } from "react";
import "./Carousel.css";
export default function Carousel({
  slides,
  renderSlide,
  interval = 4000,
  showArrows = true,
}) {
  const [current, setCurrent] = useState(0);
  useEffect(() => {
    const timer = setInterval(nextSlide, interval);
    return () => clearInterval(timer);
  }, [current]);
  const nextSlide = () =>
    setCurrent(current === slides.length - 1 ? 0 : current + 1);
  const prevSlide = () =>
    setCurrent(current === 0 ? slides.length - 1 : current - 1);
  return (
    <div className="carousel">
      {" "}
      {slides.map((slide, index) => (
        <div
          key={index}
          className={index === current ? "slide active" : "slide"}
        >
          {" "}
          {renderSlide(slide)}{" "}
        </div>
      ))}{" "}
      {showArrows && (
        <>
          {" "}
          <button className="arrow left" onClick={prevSlide}>
            {" "}
            ❮{" "}
          </button>{" "}
          <button className="arrow right" onClick={nextSlide}>
            {" "}
            ❯{" "}
          </button>{" "}
        </>
      )}{" "}
    </div>
  );
}
