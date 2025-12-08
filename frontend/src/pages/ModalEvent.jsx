import { useState } from "react";
import { X } from "lucide-react";
import "./ModalEvent.css";

export default function ModalEvent({ isOpen, onClose, onSave }) {
  const [form, setForm] = useState({
    title: "",
    date: "",
    description: "",
    details: "",
    location: "",
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setForm((prev) => ({ ...prev, [name]: value }));
  };

  const handleSubmit = () => {
    if (!form.title || !form.date) {
      alert("Por favor completa los campos obligatorios: Título y Fecha");
      return;
    }
    onSave(form);
    onClose();
    setForm({
      title: "",
      date: "",
      description: "",
      details: "",
      location: "",
    });
  };

  if (!isOpen) return null;

  return (
    <div className="modal-overlay" onClick={onClose}>
      <div className="modal-content" onClick={(e) => e.stopPropagation()}>
        <div className="modal-header">
          <h3>Nuevo Evento</h3>
          <button className="btn-close" onClick={onClose}>
            <X size={24} />
          </button>
        </div>
        <div className="modal-body">
          <label>
            Título *
            <input
              type="text"
              name="title"
              value={form.title}
              onChange={handleChange}
              placeholder="Título del evento"
            />
          </label>
          <label>
            Fecha *
            <input
              type="date"
              name="date"
              value={form.date}
              onChange={handleChange}
            />
          </label>
          <label>
            Descripción
            <textarea
              name="description"
              value={form.description}
              onChange={handleChange}
              placeholder="Breve descripción"
            />
          </label>
          <label>
            Detalles
            <textarea
              name="details"
              value={form.details}
              onChange={handleChange}
              placeholder="Detalles completos del evento"
            />
          </label>
          <label>
            Ubicación
            <input
              type="text"
              name="location"
              value={form.location}
              onChange={handleChange}
              placeholder="Lugar del evento"
            />
          </label>
        </div>
        <div className="modal-footer">
          <button className="btn-secondary" onClick={onClose}>
            Cancelar
          </button>
          <button className="btn-primary" onClick={handleSubmit}>
            Guardar
          </button>
        </div>
      </div>
    </div>
  );
}
