import { useState, useRef } from "react";
import { Lock, UserCircle } from "lucide-react";
import { useNavigate } from "react-router-dom";
import "./SignUp.css";
const api_url = import.meta.env.VITE_API_URL ?? "https://desarrolloweb-production-4918.up.railway.app";


function Login() {
  const navigate = useNavigate();
  const [formData, setFormData] = useState({});
  const [errors, setErrors] = useState({});
  const [isSubmitting, setIsSubmitting] = useState(false);
  const inputRefs = useRef([]);

  const formFields = [
    {
      name: "username",
      label: "Nombre de Usuario",
      type: "text",
      placeholder: "usuario123",
      required: true,
      icon: UserCircle,
      colSpan: "full",
    },
    {
      name: "password",
      label: "Contraseña",
      type: "password",
      placeholder: "••••••••",
      required: true,
      icon: Lock,
      colSpan: "full",
    },
  ];

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData((prev) => ({ ...prev, [name]: value }));
    if (errors[name]) setErrors((prev) => ({ ...prev, [name]: "" }));
  };

  const handleKeyDown = (e, index) => {
    if (e.key === "Enter") {
      e.preventDefault();
      if (index < formFields.length - 1) {
        inputRefs.current[index + 1].focus();
      } else {
        handleSubmit();
      }
    }
  };

  const validateForm = () => {
    const newErrors = {};
    formFields.forEach((field) => {
      if (field.required && !formData[field.name]?.trim()) {
        newErrors[field.name] = `${field.label} es requerido`;
      }
    });
    setErrors(newErrors);
    return Object.keys(newErrors).length === 0;
  };

  const handleSubmit = async () => {
    if (!validateForm()) return;

    setIsSubmitting(true);

    try {
      const response = await fetch(`${api_url}/api/auth/login`, {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({
          username: formData.username,
          password: formData.password,
        }),
      });

      if (!response.ok) {
        const errorData = await response.json();
        setIsSubmitting(false);
        alert(errorData.message || "Credenciales incorrectas");
        return;
      }

      const data = await response.json();

      // Guarda token e id
      localStorage.setItem("token", data.token);
      localStorage.setItem("id", data.id);

      setIsSubmitting(false);

      navigate("/adminDasboard");

    } catch (error) {
      console.error(error);
      setIsSubmitting(false);
      alert("Error al conectar con el servidor");
    }
  };

  return (
    <div className="registro-page">
      <div className="form-container">
        <div className="form-header">
          <div className="form-icon">
            <UserCircle size={64} />
          </div>
          <h2 className="form-title">Inicia Sesión</h2>
          <p className="form-subtitle">
            Ingresa tu usuario y contraseña para acceder a tu cuenta.
          </p>
        </div>
        <div className="contact-form">
          <div className="form-grid">
            {formFields.map((field, index) => {
              const Icon = field.icon;
              return (
                <div
                  key={field.name}
                  className={`form-group ${
                    field.colSpan === "full" ? "form-group-full" : ""
                  }`}
                >
                  <label htmlFor={field.name} className="form-label">
                    {field.label}
                    {field.required && <span className="required">*</span>}
                  </label>
                  <div className="input-wrapper">
                    <div className="input-icon">
                      <Icon size={20} />
                    </div>
                    <input
                      ref={(el) => (inputRefs.current[index] = el)}
                      type={field.type}
                      id={field.name}
                      name={field.name}
                      value={formData[field.name] || ""}
                      onChange={handleChange}
                      onKeyDown={(e) => handleKeyDown(e, index)}
                      placeholder={field.placeholder}
                      className={`form-input with-icon ${
                        errors[field.name] ? "error" : ""
                      }`}
                    />
                  </div>
                  {errors[field.name] && (
                    <span className="error-message">{errors[field.name]}</span>
                  )}
                </div>
              );
            })}
          </div>

          <button
            onClick={handleSubmit}
            className="form-submit"
            disabled={isSubmitting}
          >
            {isSubmitting ? "Ingresando..." : "Iniciar Sesión"}
          </button>
        </div>
      </div>
    </div>
  );
}

export default Login;
