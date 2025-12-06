import { useState, useRef, useEffect } from "react";
import {
  CreditCard,
  Wallet,
  Building2,
  DollarSign,
  CheckCircle,
} from "lucide-react";
import "./PaymentForm.css";

const api_url = import.meta.env.VITE_API_URL ?? "https://backend-desrrollo-production.up.railway.app";

function PaymentForm() {
  const [formData, setFormData] = useState({ paymentMethod: "" });
  const [errors, setErrors] = useState({});
  const [isSubmitting, setIsSubmitting] = useState(false);
  const [submitSuccess, setSubmitSuccess] = useState(false);
  const methodRefs = useRef([]);
  const inscriptionCost = 150000;
  const studentId = localStorage.getItem("studentId");

  useEffect(() => {
    if (!studentId) {
      alert("No se encontró el estudiante. Regístrate nuevamente.");
      window.location.href = "/signup";
    }
  }, [studentId]);

  const paymentMethods = [
    {
      id: "credit_card",
      name: "Tarjeta de Crédito/Débito",
      icon: CreditCard,
      description: "Visa, Mastercard, American Express",
    },
    {
      id: "cash",
      name: "Efectivo",
      icon: Wallet,
      description: "Pago directo en la escuela",
    },
    {
      id: "bank_transfer",
      name: "Transferencia Bancaria",
      icon: Building2,
      description: "PSE o transferencia directa",
    },
  ];

  const handleMethodChange = (methodId) => {
    setFormData({ paymentMethod: methodId });
    if (errors.paymentMethod) setErrors({});
  };

  const handleKeyDown = (e, index) => {
    if (e.key === "Enter") {
      e.preventDefault();
      handleMethodChange(paymentMethods[index].id);
    }
  };

  const validateForm = () => {
    const newErrors = {};
    if (!formData.paymentMethod)
      newErrors.paymentMethod = "Debes seleccionar un método de pago";
    setErrors(newErrors);
    return Object.keys(newErrors).length === 0;
  };

  const handleSubmit = async () => {
    if (!validateForm()) return;

    setIsSubmitting(true);

    try {
      const res = await fetch(`${api_url}/api/v1/payments/register`, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({
          studentId: Number(studentId),
          paymentMethod: formData.paymentMethod,
          amount: inscriptionCost.toString(),
          paymentDate: new Date().toISOString().split("T")[0],
        }),
      });

      if (!res.ok) throw new Error("Error en el pago");

      setSubmitSuccess(true);
    } catch (error) {
      console.error("Error al procesar el pago:", error);
      alert("No se pudo registrar el pago.");
    } finally {
      setIsSubmitting(false);
    }
  };

  const formatCurrency = (amount) =>
    new Intl.NumberFormat("es-CO", {
      style: "currency",
      currency: "COP",
      minimumFractionDigits: 0,
    }).format(amount);

  if (submitSuccess) {
    return (
      <div className="registro-page">
        <div className="form-container success-container">
          <div className="success-animation">
            <CheckCircle size={80} />
          </div>
          <h2 className="success-title">¡Inscripción Completada!</h2>
          <p className="success-text">
            Tu inscripción en Roller Speed ha sido procesada exitosamente.
          </p>
          <div className="success-details">
            <div className="detail-item">
              <span className="detail-label">Método de pago:</span>
              <span className="detail-value">
                {
                  paymentMethods.find((m) => m.id === formData.paymentMethod)
                    ?.name
                }
              </span>
            </div>
            <div className="detail-item">
              <span className="detail-label">Monto pagado:</span>
              <span className="detail-value">
                {formatCurrency(inscriptionCost)}
              </span>
            </div>
          </div>
        </div>
      </div>
    );
  }

  return (
    <div className="registro-page">
      <div className="form-container">
        <div className="form-header">
          <div className="form-icon">
            <DollarSign size={64} />
          </div>
          <h2 className="form-title">Método de Pago</h2>
          <p className="form-subtitle">
            Selecciona cómo deseas realizar el pago de tu inscripción
          </p>
        </div>

        <div className="contact-form">
          <div className="cost-display">
            <div className="cost-label">Costo de inscripción</div>
            <div className="cost-amount">{formatCurrency(inscriptionCost)}</div>
            <div className="cost-note">Pago único por inscripción</div>
          </div>

          <div className="payment-methods">
            <label className="form-label">
              Elige tu método de pago <span className="required">*</span>
            </label>
            <div className="payment-options">
              {paymentMethods.map((method, index) => {
                const Icon = method.icon;
                const isSelected = formData.paymentMethod === method.id;
                return (
                  <div
                    key={method.id}
                    ref={(el) => (methodRefs.current[index] = el)}
                    className={`payment-option ${isSelected ? "selected" : ""}`}
                    onClick={() => handleMethodChange(method.id)}
                    onKeyDown={(e) => handleKeyDown(e, index)}
                    tabIndex={0}
                  >
                    <div className="payment-option-icon">
                      <Icon size={32} />
                    </div>
                    <div className="payment-option-content">
                      <div className="payment-option-name">{method.name}</div>
                      <div className="payment-option-description">
                        {method.description}
                      </div>
                    </div>
                    <div className="payment-option-radio">
                      <div
                        className={`radio-circle ${
                          isSelected ? "checked" : ""
                        }`}
                      >
                        {isSelected && <div className="radio-dot" />}
                      </div>
                    </div>
                  </div>
                );
              })}
            </div>
            {errors.paymentMethod && (
              <span className="error-message">{errors.paymentMethod}</span>
            )}
          </div>

          <button
            onClick={handleSubmit}
            className="form-submit"
            disabled={isSubmitting}
          >
            {isSubmitting ? (
              "Procesando..."
            ) : (
              <>
                Completar Inscripción <CheckCircle size={20} />
              </>
            )}
          </button>

          <div className="form-footer">
            <p className="payment-security">
              🔒 Tu información está protegida y segura
            </p>
          </div>
        </div>
      </div>
    </div>
  );
}

export default PaymentForm;