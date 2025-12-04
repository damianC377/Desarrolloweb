import Carousel from "../components/Carousel";
import CardSection from "../components/CardSection";
import slide1 from "../assets/img/slide1.jpg";
import slide2 from "../assets/img/slide2.jpg";
import slide3 from "../assets/img/slide3.jpg";

function Home() {
  const heroSlides = [
    {
      image: slide1,
      title: "Aprende a Patinar con Pasión",
      subtitle: "Clases para todas las edades y niveles, combinando diversión y técnica.",
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
      subtitle: "“Gracias a la escuela, mi hijo aprendió a patinar y se divierte mientras mejora su técnica. ¡Excelente equipo de instructores!”",
    },
    {
      title: "María Rodríguez",
      subtitle: "“Las clases son divertidas y seguras. Me encanta el progreso de mis hijos y cómo se sienten motivados cada día.”",
    },
    {
      title: "Carlos Gómez",
      subtitle: "“Recomiendo esta escuela a todos los que quieran aprender patinaje de manera profesional y divertida.”",
    },
  ];

  return (
    <div>
      <Carousel slides={heroSlides} />
      <CardSection
        cards={[
          {
            title: "Misión",
            icon: "🎯",
            text: "Brindar educación y entretenimiento de calidad en patinaje para todas las edades, fomentando la disciplina, la diversión y el desarrollo físico y social de nuestros estudiantes en un ambiente seguro y motivador.",
          },
          {
            title: "Visión",
            icon: "👁️",
            text: "Ser reconocida como la escuela de patinaje líder en la región, destacándonos por la excelencia en la enseñanza, la innovación en nuestras clases y el impacto positivo en la vida de nuestros alumnos.",
          },
          {
            title: "Valores",
            icon: "💖",
            text: "Compromiso, respeto, responsabilidad, perseverancia y trabajo en equipo, asegurando un entorno positivo donde cada estudiante pueda crecer y disfrutar del patinaje.",
          },
        ]}
      />
      <h2 style={{ textAlign: "center", margin: "2rem 0"}}>Testimonios</h2>
      <Carousel slides={testimonialSlides} type="testimonial" />
    </div>
  );
}

export default Home;
