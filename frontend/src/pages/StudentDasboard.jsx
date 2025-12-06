import { useState } from "react";
import {
  User,
  Calendar,
  CreditCard,
  Bell,
  Clock,
  CheckCircle,
  XCircle,
  LogOut,
  Menu,
  X,
} from "lucide-react";
import "./StudentDasboard.css";

function StudentDashboard() {
  const [activeSection, setActiveSection] = useState("perfil");
  const [sidebarOpen, setSidebarOpen] = useState(false);

  // Datos de ejemplo del estudiante
  const studentData = {
    nombre: "Ana María García",
    email: "ana.garcia@email.com",
    telefono: "+57 300 1234567",
    nivel: "Intermedio",
    instructor: "Carlos Rodríguez",
    fechaInscripcion: "15 Ene 2025",
    foto: "👩‍🎓",
  };

  const horarios = [
    {
      id: 1,
      dia: "Lunes",
      hora: "4:00 PM - 6:00 PM",
      nivel: "Intermedio",
      instructor: "Carlos Rodríguez",
      salon: "Pista Principal",
    },
    {
      id: 2,
      dia: "Miércoles",
      hora: "4:00 PM - 6:00 PM",
      nivel: "Intermedio",
      instructor: "Carlos Rodríguez",
      salon: "Pista Principal",
    },
    {
      id: 3,
      dia: "Viernes",
      hora: "4:00 PM - 6:00 PM",
      nivel: "Intermedio",
      instructor: "Carlos Rodríguez",
      salon: "Pista Principal",
    },
  ];

  const pagos = [
    {
      id: 1,
      concepto: "Mensualidad Enero 2026",
      monto: "$150.000",
      fecha: "05 Ene 2026",
      estado: "Pagado",
      metodo: "Transferencia",
    },
    {
      id: 2,
      concepto: "Mensualidad Febrero 2026",
      monto: "$150.000",
      fecha: "05 Feb 2026",
      estado: "Pendiente",
      metodo: "-",
    },
    {
      id: 3,
      concepto: "Mensualidad Diciembre 2025",
      monto: "$150.000",
      fecha: "05 Dic 2025",
      estado: "Pagado",
      metodo: "Efectivo",
    },
  ];

  const notificaciones = [
    {
      id: 1,
      tipo: "pago",
      mensaje: "Tu pago de Febrero 2026 está próximo a vencer",
      fecha: "Hace 2 horas",
      leida: false,
    },
    {
      id: 2,
      tipo: "clase",
      mensaje: "Clase de mañana cancelada - Mantenimiento de pista",
      fecha: "Hace 1 día",
      leida: false,
    },
    {
      id: 3,
      tipo: "evento",
      mensaje: "Nuevo evento: Campeonato Regional - 15 Feb",
      fecha: "Hace 3 días",
      leida: true,
    },
  ];

  const renderContent = () => {
    switch (activeSection) {
      case "perfil":
        return (
          <div className="dashboard-content">
            <h2 className="section-title">Mi Perfil</h2>

            <div className="profile-card">
              <div className="profile-header">
                <div className="profile-avatar">{studentData.foto}</div>
                <div className="profile-info">
                  <h3>{studentData.nombre}</h3>
                  <span className="profile-badge">{studentData.nivel}</span>
                </div>
              </div>

              <div className="profile-details">
                <div className="detail-item">
                  <strong>Email:</strong>
                  <span>{studentData.email}</span>
                </div>
                <div className="detail-item">
                  <strong>Teléfono:</strong>
                  <span>{studentData.telefono}</span>
                </div>
                <div className="detail-item">
                  <strong>Nivel:</strong>
                  <span>{studentData.nivel}</span>
                </div>
                <div className="detail-item">
                  <strong>Instructor:</strong>
                  <span>{studentData.instructor}</span>
                </div>
                <div className="detail-item">
                  <strong>Fecha de Inscripción:</strong>
                  <span>{studentData.fechaInscripcion}</span>
                </div>
              </div>

              <button className="btn-edit">Editar Perfil</button>
            </div>
          </div>
        );

      case "horarios":
        return (
          <div className="dashboard-content">
            <h2 className="section-title">Mis Horarios</h2>

            <div className="horarios-grid">
              {horarios.map((horario) => (
                <div key={horario.id} className="horario-card">
                  <div className="horario-header">
                    <Clock size={24} />
                    <h3>{horario.dia}</h3>
                  </div>
                  <div className="horario-body">
                    <p className="horario-time">{horario.hora}</p>
                    <p className="horario-detail">
                      <strong>Nivel:</strong> {horario.nivel}
                    </p>
                    <p className="horario-detail">
                      <strong>Instructor:</strong> {horario.instructor}
                    </p>
                    <p className="horario-detail">
                      <strong>Lugar:</strong> {horario.salon}
                    </p>
                  </div>
                </div>
              ))}
            </div>
          </div>
        );

      case "pagos":
        return (
          <div className="dashboard-content">
            <h2 className="section-title">Estado de Pagos</h2>

            <div className="pagos-summary">
              <div className="summary-card pagado">
                <CheckCircle size={32} />
                <div>
                  <h4>Pagos al Día</h4>
                  <p className="summary-number">2</p>
                </div>
              </div>
              <div className="summary-card pendiente">
                <XCircle size={32} />
                <div>
                  <h4>Pagos Pendientes</h4>
                  <p className="summary-number">1</p>
                </div>
              </div>
            </div>

            <div className="pagos-table">
              <table>
                <thead>
                  <tr>
                    <th>Concepto</th>
                    <th>Monto</th>
                    <th>Fecha</th>
                    <th>Estado</th>
                    <th>Método</th>
                  </tr>
                </thead>
                <tbody>
                  {pagos.map((pago) => (
                    <tr key={pago.id}>
                      <td>{pago.concepto}</td>
                      <td className="monto">{pago.monto}</td>
                      <td>{pago.fecha}</td>
                      <td>
                        <span
                          className={`status-badge ${pago.estado.toLowerCase()}`}
                        >
                          {pago.estado}
                        </span>
                      </td>
                      <td>{pago.metodo}</td>
                    </tr>
                  ))}
                </tbody>
              </table>
            </div>
          </div>
        );

      case "notificaciones":
        return (
          <div className="dashboard-content">
            <h2 className="section-title">Notificaciones</h2>

            <div className="notificaciones-list">
              {notificaciones.map((notif) => (
                <div
                  key={notif.id}
                  className={`notif-card ${!notif.leida ? "no-leida" : ""}`}
                >
                  <div className="notif-icon">
                    {notif.tipo === "pago" && <CreditCard size={24} />}
                    {notif.tipo === "clase" && <Calendar size={24} />}
                    {notif.tipo === "evento" && <Bell size={24} />}
                  </div>
                  <div className="notif-content">
                    <p className="notif-mensaje">{notif.mensaje}</p>
                    <span className="notif-fecha">{notif.fecha}</span>
                  </div>
                  {!notif.leida && <div className="notif-dot"></div>}
                </div>
              ))}
            </div>
          </div>
        );

      default:
        return null;
    }
  };

  return (
    <div className="student-dashboard">
      {/* Sidebar */}
      <aside className={`dashboard-sidebar ${sidebarOpen ? "open" : ""}`}>
        <div className="sidebar-header">
          <h1 className="sidebar-title">Roller Speed</h1>
          <button
            className="sidebar-close"
            onClick={() => setSidebarOpen(false)}
          >
            <X size={24} />
          </button>
        </div>

        <nav className="sidebar-nav">
          <button
            className={`nav-item ${activeSection === "perfil" ? "active" : ""}`}
            onClick={() => {
              setActiveSection("perfil");
              setSidebarOpen(false);
            }}
          >
            <User size={20} />
            <span>Mi Perfil</span>
          </button>

          <button
            className={`nav-item ${
              activeSection === "horarios" ? "active" : ""
            }`}
            onClick={() => {
              setActiveSection("horarios");
              setSidebarOpen(false);
            }}
          >
            <Calendar size={20} />
            <span>Mis Horarios</span>
          </button>

          <button
            className={`nav-item ${activeSection === "pagos" ? "active" : ""}`}
            onClick={() => {
              setActiveSection("pagos");
              setSidebarOpen(false);
            }}
          >
            <CreditCard size={20} />
            <span>Pagos</span>
          </button>

          <button
            className={`nav-item ${
              activeSection === "notificaciones" ? "active" : ""
            }`}
            onClick={() => {
              setActiveSection("notificaciones");
              setSidebarOpen(false);
            }}
          >
            <Bell size={20} />
            <span>Notificaciones</span>
            {notificaciones.filter((n) => !n.leida).length > 0 && (
              <span className="notif-badge">
                {notificaciones.filter((n) => !n.leida).length}
              </span>
            )}
          </button>
        </nav>

        <button className="nav-item logout">
          <LogOut size={20} />
          <span>Cerrar Sesión</span>
        </button>
      </aside>

      {/* Main Content */}
      <main className="dashboard-main">
        <header className="dashboard-header">
          <button className="menu-toggle" onClick={() => setSidebarOpen(true)}>
            <Menu size={24} />
          </button>
          <h2>Panel de Alumno</h2>
          <div className="header-user">
            <span>{studentData.nombre}</span>
            <div className="user-avatar">{studentData.foto}</div>
          </div>
        </header>

        {renderContent()}
      </main>
    </div>
  );
}

export default StudentDashboard;
