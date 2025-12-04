import "./Card.css";

const CardSection = ({ cards }) => {
  return (
    <section className="card-section" id="nosotros">
      <div className="container">
        <h2 className="section-title">Nuestra Escuela</h2>
        <div className="card-container">
          {cards.map((card, index) => (
            <div className="card" key={index}>
              <div className="card-icon">{card.icon}</div>
              <h3 className="card-title">{card.title}</h3>
              <p className="card-text">{card.text}</p>
            </div>
          ))}
        </div>
      </div>
    </section>
  );
};

export default CardSection;
