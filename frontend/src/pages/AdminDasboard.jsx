import { useState } from "react";
import {
  LayoutDashboard,
  Users,
  GraduationCap,
  Megaphone,
  LogOut,
  Menu,
  X,
  Plus,
  Edit,
  Trash2,
  Search,
  Filter,
  Eye,
} from "lucide-react";
import "./AdminDashboard.css";

function AdminDashboard() {
  const [activeSection, setActiveSection] = useState("dashboard");
  const [sidebarOpen, setSidebarOpen] = useState(false);
  const [showModal, setShowModal] = useState(false);
  const [modalType, setModalType] = useState("");

  const stats = {
    totalAlumnos: 87,
    totalInstructores: 8,
    clasesActivas: 24,
  };

  const alumnos = [
    {
      id: 1,
      nombre: "Ana María García",
      email: "ana.garcia@email.com",
      nivel: "Intermedio",
      instructor: "Carlos Rodríguez",
      estado: "Activo",
      ultimoPago: "05 Ene 2026",
    },
    {
      id: 2,
      nombre: "Juan Pérez López",
      email: "juan.perez@email.com",
      nivel: "Avanzado",
      instructor: "María Fernández",
      estado: "Activo",
      ultimoPago: "03 Ene 2026",
    },
    {
      id: 3,
      nombre: "Sofia Ramírez",
      email: "sofia.ramirez@email.com",
      nivel: "Principiante",
      instructor: "Carlos Rodríguez",
      estado: "Pendiente",
      ultimoPago: "20 Dic 2025",
    },
  ];

  const instructores = [
    {
      id: 1,
      nombre: "Carlos Rodríguez",
      email: "carlos.r@rollerspeed.com",
      especialidad: "Intermedio/Avanzado",
      clasesAsignadas: 6,
      alumnosActivos: 32,
      estado: "Activo",
    },
    {
      id: 2,
      nombre: "María Fernández",
      email: "maria.f@rollerspeed.com",
      especialidad: "Avanzado/Competencia",
      clasesAsignadas: 5,
      alumnosActivos: 28,
      estado: "Activo",
    },
    {
      id: 3,
      nombre: "Luis Martínez",
      email: "luis.m@rollerspeed.com",
      especialidad: "Principiante",
      clasesAsignadas: 4,
      alumnosActivos: 27,
      estado: "Activo",
    },
  ];

  const eventos = [
    {
      id: 1,
      titulo: "Campeonato Regional",
      fecha: "15 Feb 2026",
      tipo: "Evento",
      estado: "Próximo",
    },
    {
      id: 2,
      titulo: "Nuevos Horarios Marzo",
      fecha: "28 Feb 2026",
      tipo: "Noticia",
      estado: "Publicado",
    },
  ];

  const openModal = (type) => {
    setModalType(type);
    setShowModal(true);
  };
  const closeModal = () => {
    setShowModal(false);
    setModalType("");
  };

  const renderContent = () => {
    switch (activeSection) {
      case "dashboard":
        return (
          <div className="dashboard-content">
            <div className="content-header">
              <h2 className="section-title">Panel General</h2>
            </div>
            <div className="stats-grid">
              <div className="stat-card blue">
                <div className="stat-icon">
                  <Users size={28} />
                </div>
                <div className="stat-info">
                  <p className="stat-label">Total Alumnos</p>
                  <h3 className="stat-value">{stats.totalAlumnos}</h3>
                </div>
              </div>
              <div className="stat-card purple">
                <div className="stat-icon">
                  <GraduationCap size={28} />
                </div>
                <div className="stat-info">
                  <p className="stat-label">Instructores</p>
                  <h3 className="stat-value">{stats.totalInstructores}</h3>
                </div>
              </div>
              <div className="stat-card green">
                <div className="stat-icon">
                  <Megaphone size={28} />
                </div>
                <div className="stat-info">
                  <p className="stat-label">Clases Activas</p>
                  <h3 className="stat-value">{stats.clasesActivas}</h3>
                </div>
              </div>
            </div>
            <div className="activity-section">
              <div className="activity-card">
                <h3 className="activity-title">Próximos Eventos</h3>
                <div className="activity-list">
                  {eventos.map((evento) => (
                    <div key={evento.id} className="activity-item">
                      <div className="activity-icon blue">
                        <Megaphone size={20} />
                      </div>
                      <div className="activity-details">
                        <p className="activity-main">{evento.titulo}</p>
                        <p className="activity-sub">{evento.tipo}</p>
                      </div>
                      <span className="activity-time">{evento.fecha}</span>
                    </div>
                  ))}
                </div>
              </div>
            </div>
          </div>
        );
      case "alumnos":
        return (
          <div className="dashboard-content">
            <div className="content-header">
              <h2 className="section-title">Gestión de Alumnos</h2>
              <button
                className="btn-primary"
                onClick={() => openModal("alumno")}
              >
                <Plus size={20} />
                Nuevo Alumno
              </button>
            </div>
            <div className="table-controls">
              <div className="search-box">
                <Search size={20} />
                <input type="text" placeholder="Buscar alumno..." />
              </div>
              <button className="btn-filter">
                <Filter size={20} />
                Filtros
              </button>
            </div>
            <div className="data-table">
              <table>
                <thead>
                  <tr>
                    <th>Alumno</th>
                    <th>Email</th>
                    <th>Nivel</th>
                    <th>Instructor</th>
                    <th>Estado</th>
                    <th>Último Pago</th>
                  </tr>
                </thead>
                <tbody>
                  {alumnos.map((alumno) => (
                    <tr key={alumno.id}>
                      <td className="name-cell">{alumno.nombre}</td>
                      <td>{alumno.email}</td>
                      <td>
                        <span className="badge level">{alumno.nivel}</span>
                      </td>
                      <td>{alumno.instructor}</td>
                      <td>
                        <span
                          className={`badge ${alumno.estado.toLowerCase()}`}
                        >
                          {alumno.estado}
                        </span>
                      </td>
                      <td>{alumno.ultimoPago}</td>
                      {/* <td className="action-buttons">
                        <button className="btn-icon">
                          <Eye size={18} />
                        </button>
                        <button className="btn-icon">
                          <Edit size={18} />
                        </button>
                        <button className="btn-icon danger">
                          <Trash2 size={18} />
                        </button>
                      </td> */}
                    </tr>
                  ))}
                </tbody>
              </table>
            </div>
          </div>
        );
      case "instructores":
        return (
          <div className="dashboard-content">
            <div className="content-header">
              <h2 className="section-title">Gestión de Instructores</h2>
              <button
                className="btn-primary"
                onClick={() => openModal("instructor")}
              >
                <Plus size={20} />
                Nuevo Instructor
              </button>
            </div>
            <div className="instructores-grid">
              {instructores.map((instructor) => (
                <div key={instructor.id} className="instructor-card">
                  <div className="instructor-header">
                    <div className="instructor-avatar">
                      {instructor.nombre.charAt(0)}
                    </div>
                    <span
                      className={`badge ${instructor.estado.toLowerCase()}`}
                    >
                      {instructor.estado}
                    </span>
                  </div>
                  <div className="instructor-body">
                    <h3>{instructor.nombre}</h3>
                    <p className="instructor-email">{instructor.email}</p>
                    <p className="instructor-specialty">
                      {instructor.especialidad}
                    </p>
                    <div className="instructor-stats">
                      <div className="instructor-stat">
                        <span className="stat-number">
                          {instructor.clasesAsignadas}
                        </span>
                        <span className="stat-label">Clases</span>
                      </div>
                      <div className="instructor-stat">
                        <span className="stat-number">
                          {instructor.alumnosActivos}
                        </span>
                        <span className="stat-label">Alumnos</span>
                      </div>
                    </div>
                  </div>
                  {/* <div className="instructor-actions">
                    <button className="btn-secondary">
                      <Edit size={18} />
                      Editar
                    </button>
                    <button className="btn-icon danger">
                      <Trash2 size={18} />
                    </button>
                  </div> */}
                </div>
              ))}
            </div>
          </div>
        );
      case "eventos":
        return (
          <div className="dashboard-content">
            <div className="content-header">
              <h2 className="section-title">Gestión de eventos</h2>
              <button
                className="btn-primary"
                onClick={() => openModal("evento")}
              >
                <Plus size={20} />
                Publicar
              </button>
            </div>
            <div className="eventos-list">
              {eventos.map((evento) => (
                <div key={evento.id} className="evento-card">
                  <div className="evento-icon">
                    <Megaphone size={32} />
                  </div>
                  <div className="evento-content">
                    <div className="evento-header">
                      <h3>{evento.titulo}</h3>
                      <span className={`badge ${evento.estado.toLowerCase()}`}>
                        {evento.estado}
                      </span>
                    </div>
                    <p className="evento-date">{evento.fecha}</p>
                    <span className="evento-type">{evento.tipo}</span>
                  </div>
                  <div className="evento-actions">
                    <button className="btn-icon danger">
                      <Edit size={18} />
                    </button>
                    <button className="btn-icon danger">
                      <Trash2 size={18} />
                    </button>
                  </div>
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
    <div className="admin-dashboard">
      <aside className={`admin-sidebar ${sidebarOpen ? "open" : ""}`}>
        <div className="sidebar-header">
          <h1 className="sidebar-title">Admin Panel</h1>
          <button
            className="sidebar-close"
            onClick={() => setSidebarOpen(false)}
          >
            <X size={24} />
          </button>
        </div>
        <nav className="sidebar-nav">
          <button
            className={`nav-item ${
              activeSection === "dashboard" ? "active" : ""
            }`}
            onClick={() => {
              setActiveSection("dashboard");
              setSidebarOpen(false);
            }}
          >
            <LayoutDashboard size={20} />
            <span>Dashboard</span>
          </button>
          <button
            className={`nav-item ${
              activeSection === "alumnos" ? "active" : ""
            }`}
            onClick={() => {
              setActiveSection("alumnos");
              setSidebarOpen(false);
            }}
          >
            <Users size={20} />
            <span>Alumnos</span>
          </button>
          <button
            className={`nav-item ${
              activeSection === "instructores" ? "active" : ""
            }`}
            onClick={() => {
              setActiveSection("instructores");
              setSidebarOpen(false);
            }}
          >
            <GraduationCap size={20} />
            <span>Instructores</span>
          </button>
          <button
            className={`nav-item ${
              activeSection === "eventos" ? "active" : ""
            }`}
            onClick={() => {
              setActiveSection("eventos");
              setSidebarOpen(false);
            }}
          >
            <Megaphone size={20} />
            <span>Eventos</span>
          </button>
        </nav>
        <button className="nav-item logout">
          <LogOut size={20} />
          <span>Cerrar Sesión</span>
        </button>
      </aside>

      <main className="admin-main">
        <header className="admin-header">
          <button className="menu-toggle" onClick={() => setSidebarOpen(true)}>
            <Menu size={24} />
          </button>
          <h2>Roller Speed - Administración</h2>
          <div className="header-user">
            <span>Admin</span>
            <div className="user-avatar">A</div>
          </div>
        </header>
        {renderContent()}
      </main>

      {showModal && (
        <div className="modal-overlay" onClick={closeModal}>
          <div className="modal-content" onClick={(e) => e.stopPropagation()}>
            <div className="modal-header">
              <h3>
                {modalType === "alumno" && "Nuevo Alumno"}
                {modalType === "instructor" && "Nuevo Instructor"}
                {modalType === "evento" && "Publicar Evento/Noticia"}
              </h3>
              <button className="btn-close" onClick={closeModal}>
                <X size={24} />
              </button>
            </div>
            <div className="modal-body">
              <p>Formulario para {modalType} - Implementar según necesidades</p>
            </div>
            <div className="modal-footer">
              <button className="btn-secondary" onClick={closeModal}>
                Cancelar
              </button>
              <button className="btn-primary">Guardar</button>
            </div>
          </div>
        </div>
      )}
    </div>
  );
}

export default AdminDashboard;
