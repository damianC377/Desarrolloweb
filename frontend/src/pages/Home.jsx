import Carousel from "../components/Carousel";
import CardSection from "../components/CardSection";
import slide1 from "../assets/img/slide1.jpg";
import slide2 from "../assets/img/slide2.jpg";
import slide3 from "../assets/img/slide3.jpg";
import "./Home.css";

import { Target, Eye } from "lucide-react";

function Home() {
  const heroSlides = [
    {
      image: slide1,
      title: "Aprende a Patinar con Pasión",
      subtitle:
        "Clases para todas las edades y niveles, combinando diversión y técnica.",
    },
    {
      image: slide2,
      title: "Instructores Profesionales",
      subtitle: "Equipo certificado que te guía con experiencia y entusiasmo.",
    },
    {
      image: slide3,
      title: "Instalaciones Modernas",
      subtitle: "Espacios diseñados para tu seguridad y comodidad.",
    },
  ];

  const testimonialSlides = [
    {
      title: "Juan Pérez",
      subtitle:
        "Gracias a la escuela, mi hijo aprendió a patinar y se divierte mientras mejora su técnica. ¡Excelente equipo de instructores!",
    },
    {
      title: "María Rodríguez",
      subtitle:
        "Las clases son divertidas y seguras. Me encanta el progreso de mis hijos y cómo se sienten motivados cada día.",
    },
    {
      title: "Carlos Gómez",
      subtitle:
        "Recomiendo esta escuela a todos los que quieran aprender patinaje de manera profesional y divertida.",
    },
  ];

  return (
    <div className="home-page">
      <div className="hero-carousel">
        <Carousel
          slides={heroSlides}
          renderSlide={(slide) => (
            <div
              className="hero-slide"
              style={{
                backgroundImage: `url(${slide.image})`,
                backgroundSize: "cover",
                backgroundPosition: "center",
                height: "100%",
                width: "100%",
              }}
            >
              <div className="carousel-content">
                <h1>{slide.title}</h1>
                <p>{slide.subtitle}</p>
              </div>
            </div>
          )}
          showDots={true}
        />
      </div>

      <CardSection
        cards={[
          {
            title: "Misión",
            icon: <Target size={32} color="var(--primary)" />,
            text: "Brindar educación y entretenimiento de calidad en patinaje para todas las edades, fomentando la disciplina, la diversión y el desarrollo físico y social de nuestros estudiantes en un ambiente seguro y motivador.",
          },
          {
            title: "Visión",
            icon: <Eye size={32} color="var(--primary)" />,
            text: "Ser reconocida como la escuela de patinaje líder en la región, destacándonos por la excelencia en la enseñanza, la innovación en nuestras clases y el impacto positivo en la vida de nuestros alumnos.",
          },
        ]}
      />

      <h2 className="testimonials-title">Testimonios</h2>
      <div className="testimonial-carousel">
        <Carousel
          slides={testimonialSlides}
          renderSlide={(slide) => (
            <div className="testimonial-content">
              <h3>{slide.title}</h3>
              <p>{slide.subtitle}</p>
            </div>
          )}
        />
      </div>
    </div>
  );
}

export default Home;
