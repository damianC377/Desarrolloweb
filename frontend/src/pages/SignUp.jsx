import { useState } from "react";
import { Send, User, Mail, Phone, MapPin, CreditCard, Lock, UserCircle } from "lucide-react";
import "./SignUp.css";

const api_url = import.meta.env.VITE_API_URL ?? "http://localhost:8080"

function SignUp() {
  const [formData, setFormData] = useState({});
  const [errors, setErrors] = useState({});
  const [isSubmitting, setIsSubmitting] = useState(false);
  const [submitSuccess, setSubmitSuccess] = useState(false);

  const formFields = [
    {
      name: "document",
      label: "Número de Documento",
      type: "number",
      placeholder: "1234567890",
      required: true,
      icon: CreditCard,
      colSpan: "half"
    },
    {
      name: "name",
      label: "Nombre",
      type: "text",
      placeholder: "Tu nombre",
      required: true,
      icon: User,
      colSpan: "half"
    },
    {
      name: "lastname",
      label: "Apellido",
      type: "text",
      placeholder: "Tu apellido",
      required: true,
      icon: User,
      colSpan: "half"
    },
    {
      name: "email",
      label: "Correo Electrónico",
      type: "email",
      placeholder: "tu@email.com",
      required: true,
      icon: Mail,
      colSpan: "half"
    },
    {
      name: "phone",
      label: "Teléfono",
      type: "tel",
      placeholder: "+57 300 1234567",
      required: true,
      icon: Phone,
      colSpan: "half"
    },
    {
      name: "address",
      label: "Dirección",
      type: "text",
      placeholder: "Calle 123 #45-67",
      required: true,
      icon: MapPin,
      colSpan: "half"
    },
    {
      name: "username",
      label: "Nombre de Usuario",
      type: "text",
      placeholder: "usuario123",
      required: true,
      icon: UserCircle,
      colSpan: "full"
    },
    {
      name: "password",
      label: "Contraseña",
      type: "password",
      placeholder: "••••••••",
      required: true,
      icon: Lock,
      colSpan: "full"
    }
  ];

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData(prev => ({
      ...prev,
      [name]: value
    }));
    
    if (errors[name]) {
      setErrors(prev => ({
        ...prev,
        [name]: ""
      }));
    }
  };

  const validateForm = () => {
    const newErrors = {};
    
    formFields.forEach(field => {
      if (field.required && !formData[field.name]?.toString().trim()) {
        newErrors[field.name] = `${field.label} es requerido`;
      }
      
      if (field.type === "email" && formData[field.name]) {
        const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        if (!emailRegex.test(formData[field.name])) {
          newErrors[field.name] = "Email inválido";
        }
      }

      if (field.name === "password" && formData[field.name]) {
        if (formData[field.name].length < 6) {
          newErrors[field.name] = "La contraseña debe tener al menos 6 caracteres";
        }
      }

      if (field.name === "document" && formData[field.name]) {
        if (formData[field.name].toString().length < 6) {
          newErrors[field.name] = "Documento inválido";
        }
      }
    });
    
    setErrors(newErrors);
    return Object.keys(newErrors).length === 0;
  };

  const handleSubmit = async () => {
    if (!validateForm()) {
      return;
    }
    
    setIsSubmitting(true);
    
    try {
      console.log("Datos del formulario:", formData);
      
      const res = await fetch(`${api_url}/api/v1/users/register`, {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify({
        document: formData.document,
        name: formData.name,
        lastname: formData.lastname,
        email: formData.email,
        phone: formData.phone,
        address: formData.address,
        username: formData.username,
        password: formData.password
          
        })
      })
      
      setSubmitSuccess(true);
      setFormData({});
      
      setTimeout(() => {
        setSubmitSuccess(false);
      }, 4000);
    } catch (error) {
      console.error("Error al registrar aspirante:", error);
    } finally {
      setIsSubmitting(false);
    }
  };

  return (
    <div className="registro-page">
      <div className="form-container">
        <div className="form-header">
          <div className="form-icon">
            <UserCircle size={64} />
          </div>
          <h2 className="form-title">¡Únete a Roller Speed!</h2>
          <p className="form-subtitle">
            Completa el formulario para inscribirte en la escuela de patinaje Roller Speed
          </p>
        </div>

        <div className="contact-form">
          <div className="form-grid">
            {formFields.map((field) => {
              const Icon = field.icon;
              
              return (
                <div 
                  key={field.name} 
                  className={`form-group ${field.colSpan === "full" ? "form-group-full" : ""}`}
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
                      type={field.type}
                      id={field.name}
                      name={field.name}
                      value={formData[field.name] || ""}
                      onChange={handleChange}
                      placeholder={field.placeholder}
                      className={`form-input with-icon ${errors[field.name] ? "error" : ""}`}
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
            {isSubmitting ? (
              "Registrando..."
            ) : (
              <>
                Inscribirme
                <Send size={18} />
              </>
            )}
          </button>

          {submitSuccess && (
            <div className="success-message">
              ¡Registro exitoso! Ahora eres parte de Roller Speed.
            </div>
          )}

          <div className="form-footer">
            <p>
              ¿Ya estás registrado?{" "}
              <a href="#login" className="form-link">
                Inicia sesión aquí
              </a>
            </p>
          </div>
        </div>
      </div>
    </div>
  );
}

export default SignUp;
