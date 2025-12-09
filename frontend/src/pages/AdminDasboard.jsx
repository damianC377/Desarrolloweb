import { useState, useEffect } from "react";
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
} from "lucide-react";
import ModalEvent from "./ModalEvent";
import RegisterInstructorModal from "./RegisterInstructorModal";
import "./AdminDashboard.css";
import { useNavigate } from "react-router-dom";

const api_url =
  import.meta.env.VITE_API_URL ??
  "https://backend-desrrollo-production.up.railway.app";

function AdminDashboard() {
  const [activeSection, setActiveSection] = useState("dashboard");
  const [sidebarOpen, setSidebarOpen] = useState(false);
  const [showModal, setShowModal] = useState(false);
  const [modalType, setModalType] = useState("");
  const [showEventoModal, setShowEventoModal] = useState(false);
  const [showInstructorModal, setShowInstructorModal] = useState(false);

  const [alumnos, setAlumnos] = useState([]);
  const [payments, setPayments] = useState([]);

  const [instructores, setInstructores] = useState([
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
  ]);

  const stats = {
    totalAlumnos: alumnos.length,
    totalInstructores: instructores.length,
    clasesActivas: 24,
  };

  const [eventos, setEventos] = useState([
    {
      id: 1,
      titulo: "Campeonato Regional",
      fecha: "15 Feb 2026",
      tipo: "Competencia",
      estado: "Próximo",
    },
    {
      id: 2,
      titulo: "Clase Especial",
      fecha: "20 Feb 2026",
      tipo: "Clase",
      estado: "Próximo",
    },
    {
      id: 3,
      titulo: "Reunión de Padres",
      fecha: "25 Feb 2026",
      tipo: "Evento",
      estado: "Próximo",
    },
  ]);

  useEffect(() => {
    const token = localStorage.getItem("token");

    const fetchAlumnos = async () => {
      if (!token) return;
      try {
        const res = await fetch(`${api_url}/api/v1/administrative/students`, {
          method: "GET",
          headers: {
            Authorization: `Bearer ${token}`,
            "Content-Type": "application/json",
          },
        });
        if (res.ok) {
          const data = await res.json();

          // Filtrar solo estudiantes con usuario válido
          const alumnosValidos = data.filter(
            (alumno) =>
              alumno.user !== null &&
              alumno.userId > 0 &&
              alumno.user.name &&
              alumno.user.email
          );

          setAlumnos(alumnosValidos);
        }
      } catch (e) {
        console.error(e);
      }
    };

    const fetchPayments = async () => {
      if (!token) return;
      try {
        const res = await fetch(`${api_url}/api/v1/payments`, {
          method: "GET",
          headers: {
            Authorization: `Bearer ${token}`,
            "Content-Type": "application/json",
          },
        });
        if (res.ok) {
          const data = await res.json();
          setPayments(data);
        }
      } catch (e) {
        console.error(e);
      }
    };

      const fetchEventos = async () => {
        try {
          const res = await fetch(`${api_url}/api/v1/administrative/showevents`);
          if (res.ok) {
            const data = await res.json();
            setEventos(data);
          }
        } catch (e) {
          console.error(e);
        }
      };

    fetchAlumnos();
    fetchPayments();
    fetchEventos();
  }, []);

  const openModal = (type) => {
    setModalType(type);
    setShowModal(true);
  };
  const closeModal = () => {
    setShowModal(false);
    setModalType("");
  };

  const navigate = useNavigate();

  const handleLogout = () => {
    localStorage.removeItem("token");
    navigate("/login");
  };

  const openEventoModal = () => setShowEventoModal(true);
  const closeEventoModal = () => setShowEventoModal(false);
  const openInstructorModal = () => setShowInstructorModal(true);
  const closeInstructorModal = () => setShowInstructorModal(false);

  const handleSaveEvento = async (eventoData) => {
    try {
    const token = localStorage.getItem("token");
    if (!token) {
      alert("No hay token, inicia sesión");
      return;
    }

    const payload = { ...eventoData, userId: 1 };

    const res = await fetch(`${api_url}/api/v1/administrative/events`, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
        "Authorization": `Bearer ${token}`,   // FALTABA ESTO
      },
      body: JSON.stringify(payload),
    });

    if (!res.ok) throw new Error("Error al crear evento");

    const newEvent = await res.json();
    setEventos((prev) => [...prev, newEvent]);

  } catch (e) {
    console.error(e);
    alert("No se pudo crear el evento");
  }
  };

  const handleInstructorSuccess = (data) => {
    const newInstructor = {
      id: data.instructorId || Date.now(),
      nombre: `${data.name} ${data.lastname}`,
      email: data.email,
      especialidad: "Por asignar",
      clasesAsignadas: 0,
      alumnosActivos: 0,
      estado: "Activo",
    };
    setInstructores((prev) => [...prev, newInstructor]);
    alert(`Instructor ${data.name} ${data.lastname} creado correctamente`);
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
                        <p className="activity-main">
                          {evento.titulo || evento.title}
                        </p>
                        <p className="activity-sub">
                          {evento.tipo || "Evento"}
                        </p>
                      </div>
                      <span className="activity-time">
                        {evento.fecha || evento.date}
                      </span>
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
            </div>

            <div className="table-controls">
              <div className="search-box">
                <Search size={20} />
                <input type="text" placeholder="Buscar alumno..." />
              </div>
              <button className="btn-filter">
                <Filter size={20} /> Filtros
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
                  {alumnos.length === 0 ? (
                    <tr>
                      <td colSpan="6" style={{ textAlign: "center" }}>
                        No hay alumnos disponibles
                      </td>
                    </tr>
                  ) : (
                    alumnos.map((alumno) => {
                      const alumnoPayments = payments.filter(
                        (p) => p.studentId === alumno.studentId
                      );

                      const lastPayment =
                        alumnoPayments.length > 0
                          ? alumnoPayments.sort(
                              (a, b) =>
                                new Date(b.paymentDate) -
                                new Date(a.paymentDate)
                            )[0].paymentDate
                          : null;

                      return (
                        <tr key={alumno.studentId}>
                          {/* ⭐ CAMBIO APLICADO AQUÍ ⭐ */}
                          <td className="name-cell">
                            {alumno.user
                              ? `${alumno.user.name} ${alumno.user.lastname}`
                              : "Sin usuario"}
                          </td>

                          <td>{alumno.user?.email || "Sin email"}</td>

                          <td>
                            <span className="badge level">
                              {alumno.level || "Pendiente"}
                            </span>
                          </td>

                          <td>{alumno.instructor || "Pendiente"}</td>

                          <td>
                            <span
                              className={`badge ${
                                alumno.active ? "activo" : "inactivo"
                              }`}
                            >
                              {alumno.active ? "Activo" : "Inactivo"}
                            </span>
                          </td>

                          <td>
                            {lastPayment
                              ? new Date(lastPayment).toLocaleDateString()
                              : "-"}
                          </td>
                        </tr>
                      );
                    })
                  )}
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
              <button className="btn-primary" onClick={openInstructorModal}>
                <Plus size={20} /> Nuevo Instructor
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
              <button className="btn-primary" onClick={openEventoModal}>
                <Plus size={20} /> Publicar
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
                      <h3>{evento.titulo || evento.title}</h3>
                      <span className={`badge ${evento.estado?.toLowerCase()}`}>
                        {evento.estado || "Próximo"}
                      </span>
                    </div>
                    <p className="evento-date">{evento.fecha || evento.date}</p>
                    <span className="evento-type">
                      {evento.tipo || "Evento"}
                    </span>
                  </div>
                  {/* <div className="evento-actions">
                    <button className="btn-icon danger">
                      <Edit size={18} />
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
      default:
        return null;
    }
  };

  return (
    <div className="admin-dashboard">
      <aside className={`admin-sidebar ${sidebarOpen ? "open" : ""}`}>
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
            className={`nav-item ${
              activeSection === "dashboard" ? "active" : ""
            }`}
            onClick={() => setActiveSection("dashboard")}
          >
            <LayoutDashboard size={20} />
            <span>Dashboard</span>
          </button>
          <button
            className={`nav-item ${
              activeSection === "alumnos" ? "active" : ""
            }`}
            onClick={() => setActiveSection("alumnos")}
          >
            <Users size={20} />
            <span>Alumnos</span>
          </button>
          <button
            className={`nav-item ${
              activeSection === "instructores" ? "active" : ""
            }`}
            onClick={() => setActiveSection("instructores")}
          >
            <GraduationCap size={20} />
            <span>Instructores</span>
          </button>
          <button
            className={`nav-item ${
              activeSection === "eventos" ? "active" : ""
            }`}
            onClick={() => setActiveSection("eventos")}
          >
            <Megaphone size={20} />
            <span>Eventos</span>
          </button>
        </nav>
        <button className="nav-item logout" onClick={handleLogout}>
          <LogOut size={20} />
          <span>Cerrar Sesión</span>
        </button>
      </aside>

      <main className="admin-main">
        <header className="admin-header">
          <button className="menu-toggle" onClick={() => setSidebarOpen(true)}>
            <Menu size={24} />
          </button>
          <h2>Panel Administración</h2>
          <div className="header-user">
            <span>Admin</span>
            <div className="user-avatar">A</div>
          </div>
        </header>

        {renderContent()}
      </main>

      <ModalEvent
        isOpen={showEventoModal}
        onClose={closeEventoModal}
        onSave={handleSaveEvento}
      />
      <RegisterInstructorModal
        isOpen={showInstructorModal}
        onClose={closeInstructorModal}
        onSuccess={handleInstructorSuccess}
      />
    </div>
  );
}

export default AdminDashboard;
