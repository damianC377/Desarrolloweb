import Hero from "../components/Carousel";
import CardSection from "../components/CardSection";

function Home() {
  return (
    <div>
      <Hero />
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
        ]}
      />
    </div>
  );
}

export default Home;
