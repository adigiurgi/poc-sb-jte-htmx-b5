@import java.util.Map

@param String contextPath

<div class="container-fluid py-4">
    <div class="row mb-4">
        <div class="col-12">
            <div class="d-flex justify-content-between align-items-center mb-4">
                <h2 class="fw-bold"><i class="bi bi-question-circle me-2"></i>Ghid de utilizare</h2>
                <small class="text-muted">SFINX ERP Portal</small>
            </div>
            <hr>
        </div>
    </div>

    <div class="row g-4">
        <!-- Introducere card -->
        <div class="col-md-6">
            <div class="card h-100 shadow-sm">
                <div class="card-header bg-primary text-white">
                    <h5 class="mb-0"><i class="bi bi-info-circle me-2"></i>Introducere</h5>
                </div>
                <div class="card-body">
                    <p class="card-text">Aplicația SFINX este un portal web pentru un sistem ERP mai mare, 
                    utilizând arhitectura hexagonală și integrarea cu Oracle SSO în mediul de producție.</p>
                    <h6 class="fw-bold mt-3">Tehnologii utilizate:</h6>
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item"><i class="bi bi-check-circle-fill text-success me-2"></i>Spring Boot 2.7.18</li>
                        <li class="list-group-item"><i class="bi bi-check-circle-fill text-success me-2"></i>Java 17</li>
                        <li class="list-group-item"><i class="bi bi-check-circle-fill text-success me-2"></i>JTE (Java Template Engine)</li>
                        <li class="list-group-item"><i class="bi bi-check-circle-fill text-success me-2"></i>HTMX 2.0.4</li>
                        <li class="list-group-item"><i class="bi bi-check-circle-fill text-success me-2"></i>Bootstrap 5</li>
                    </ul>
                </div>
            </div>
        </div>

        <!-- Profiluri card -->
        <div class="col-md-6">
            <div class="card h-100 shadow-sm">
                <div class="card-header bg-primary text-white">
                    <h5 class="mb-0"><i class="bi bi-person-badge me-2"></i>Profiluri utilizator</h5>
                </div>
                <div class="card-body">
                    <p class="card-text">Aplicația permite gestionarea profilurilor utilizatorilor disponibile în ERP:</p>
                    <ul>
                        <li>Cel mai vechi profil este setat ca implicit și stocat în tabela <code>WEBAPP.USER_ACTIVE_PROFILE</code></li>
                        <li>Puteți schimba între profile direct din acest portal, folosind meniul din colțul dreapta sus</li>
                        <li>La schimbarea profilului, interfața se va actualiza automat pentru a afișa notificările și opțiunile de meniu corespunzătoare</li>
                    </ul>
                    <div class="alert alert-info mt-3" role="alert">
                        <i class="bi bi-lightbulb me-2"></i>Profilul activ este partajat între toate modulele ERP
                    </div>
                </div>
            </div>
        </div>

        <!-- Notificări card -->
        <div class="col-md-6">
            <div class="card h-100 shadow-sm">
                <div class="card-header bg-primary text-white">
                    <h5 class="mb-0"><i class="bi bi-bell me-2"></i>Notificări</h5>
                </div>
                <div class="card-body">
                    <p class="card-text">Sistemul de notificări funcționează în două moduri:</p>
                    <div class="accordion" id="notificationAccordion">
                        <div class="accordion-item">
                            <h2 class="accordion-header">
                                <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseOne" aria-expanded="false" aria-controls="collapseOne">
                                    1. Modul determinist (legacy)
                                </button>
                            </h2>
                            <div id="collapseOne" class="accordion-collapse collapse" data-bs-parent="#notificationAccordion">
                                <div class="accordion-body">
                                    La cererea utilizatorului, aplicația execută proceduri de baze de date care verifică condițiile pentru notificări și le inserează într-o tabelă din care sunt citite și afișate.
                                </div>
                            </div>
                        </div>
                        <div class="accordion-item">
                            <h2 class="accordion-header">
                                <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                                    2. Modul event-driven (nou)
                                </button>
                            </h2>
                            <div id="collapseTwo" class="accordion-collapse collapse" data-bs-parent="#notificationAccordion">
                                <div class="accordion-body">
                                    Aplicația citește notificările direct din baza de date. Acestea sunt produse de modulele ERP și sunt inserate în tabelă când condițiile sunt îndeplinite.
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- Navigare card -->
        <div class="col-md-6">
            <div class="card h-100 shadow-sm">
                <div class="card-header bg-primary text-white">
                    <h5 class="mb-0"><i class="bi bi-grid me-2"></i>Meniu de navigare</h5>
                </div>
                <div class="card-body">
                    <p class="card-text">Portalul afișează toate modulele ERP disponibile pentru profilul curent, grupate în următoarele categorii:</p>
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item d-flex align-items-center">
                            <span class="badge bg-secondary rounded-pill me-2">1</span> Introducere
                        </li>
                        <li class="list-group-item d-flex align-items-center">
                            <span class="badge bg-secondary rounded-pill me-2">2</span> Căutare
                        </li>
                        <li class="list-group-item d-flex align-items-center">
                            <span class="badge bg-secondary rounded-pill me-2">3</span> Statistici
                        </li>
                        <li class="list-group-item d-flex align-items-center">
                            <span class="badge bg-secondary rounded-pill me-2">4</span> Administrare
                        </li>
                    </ul>
                    <div class="alert alert-warning mt-3" role="alert">
                        <i class="bi bi-exclamation-triangle me-2"></i>Modulele afișate depind de rolurile și privilegiile asociate profilului activ
                    </div>
                </div>
            </div>
        </div>

        <!-- CLI card -->
        <div class="col-md-12">
            <div class="card h-100 shadow-sm">
                <div class="card-header bg-primary text-white">
                    <h5 class="mb-0"><i class="bi bi-terminal me-2"></i>Interfața în linie de comandă (CLI)</h5>
                </div>
                <div class="card-body">
                    <p class="card-text">Pentru testarea aplicației, puteți utiliza următoarele comenzi CLI:</p>
                    
                    <h6 class="fw-bold mt-3">Managementul utilizatorilor:</h6>
                    <div class="table-responsive">
                        <table class="table table-striped table-bordered">
                            <thead class="table-light">
                                <tr>
                                    <th>Comandă</th>
                                    <th>Descriere</th>
                                    <th>Exemplu</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td><code>create-user &lt;username&gt; &lt;firstname&gt; &lt;lastname&gt;</code></td>
                                    <td>Creează un utilizator nou</td>
                                    <td><code>create-user john.doe John Doe</code></td>
                                </tr>
                                <tr>
                                    <td><code>create-profile &lt;userId&gt; &lt;profileName&gt;</code></td>
                                    <td>Creează un profil nou pentru un utilizator</td>
                                    <td><code>create-profile 1 First_Profile</code></td>
                                </tr>
                                <tr>
                                    <td><code>create-role &lt;userId&gt; &lt;roleName&gt; &lt;roleDescription&gt;</code></td>
                                    <td>Creează un rol nou pentru un utilizator</td>
                                    <td><code>create-role 1 WEBAPP_ROLE</code></td>
                                </tr>
                            </tbody>
                        </table>
                    </div>

                    <h6 class="fw-bold mt-3">Comenzi de administrare:</h6>
                    <div class="table-responsive">
                        <table class="table table-striped table-bordered">
                            <thead class="table-light">
                                <tr>
                                    <th>Comandă</th>
                                    <th>Descriere</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td><code>system-info</code></td>
                                    <td>Afișează informații despre sistem</td>
                                </tr>
                                <tr>
                                    <td><code>app-help</code></td>
                                    <td>Ghid pentru CLI</td>
                                </tr>
                            </tbody>
                        </table>
                    </div>

                    <div class="mt-4">
                        <h6 class="fw-bold">Configurare minimă pentru testare:</h6>
                        <div class="bg-light p-3 rounded border">
                            <code>
                                webapp-cli:&gt; create-user john.doe John Doe<br>
                                webapp-cli:&gt; create-profile 1 First_Profile<br>
                                webapp-cli:&gt; create-role 1 WEBAPP_ROLE<br>
                                webapp-cli:&gt; system-info
                            </code>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
