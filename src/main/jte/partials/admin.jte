@param String contextPath

<!-- Partial pentru Administrare -->
<div class="container-fluid py-3">
    <h2 class="mb-4">Administrare</h2>
    
    <div class="row mb-4">
        <div class="col-md-4 mb-4 mb-md-0">
            <div class="card h-100">
                <div class="card-header">
                    <h5 class="card-title mb-0">Meniu rapid</h5>
                </div>
                <div class="card-body">
                    <div class="list-group">
                        <a href="#" class="list-group-item list-group-item-action d-flex align-items-center">
                            <i class="bi bi-people me-3 text-primary"></i>
                            Administrare utilizatori
                        </a>
                        <a href="#" class="list-group-item list-group-item-action d-flex align-items-center">
                            <i class="bi bi-shield-lock me-3 text-primary"></i>
                            Roluri și permisiuni
                        </a>
                        <a href="#" class="list-group-item list-group-item-action d-flex align-items-center">
                            <i class="bi bi-gear me-3 text-primary"></i>
                            Configurare sistem
                        </a>
                        <a href="#" class="list-group-item list-group-item-action d-flex align-items-center">
                            <i class="bi bi-database me-3 text-primary"></i>
                            Backup și restaurare
                        </a>
                        <a href="#" class="list-group-item list-group-item-action d-flex align-items-center">
                            <i class="bi bi-file-earmark-text me-3 text-primary"></i>
                            Jurnale sistem
                        </a>
                    </div>
                </div>
            </div>
        </div>
        
        <div class="col-md-8">
            <div class="card">
                <div class="card-header">
                    <h5 class="card-title mb-0">Stare sistem</h5>
                </div>
                <div class="card-body">
                    <div class="row">
                        <div class="col-md-6 mb-4">
                            <h6 class="fw-semibold">Resurse server</h6>
                            <div class="mb-3">
                                <label class="form-label d-flex justify-content-between mb-1">
                                    <span>CPU</span>
                                    <span>34%</span>
                                </label>
                                <div class="progress" style="height: 8px;">
                                    <div class="progress-bar bg-success" role="progressbar" style="width: 34%;" aria-valuenow="34" aria-valuemin="0" aria-valuemax="100"></div>
                                </div>
                            </div>
                            
                            <div class="mb-3">
                                <label class="form-label d-flex justify-content-between mb-1">
                                    <span>Memorie</span>
                                    <span>67%</span>
                                </label>
                                <div class="progress" style="height: 8px;">
                                    <div class="progress-bar bg-warning" role="progressbar" style="width: 67%;" aria-valuenow="67" aria-valuemin="0" aria-valuemax="100"></div>
                                </div>
                            </div>
                            
                            <div class="mb-3">
                                <label class="form-label d-flex justify-content-between mb-1">
                                    <span>Stocare</span>
                                    <span>42%</span>
                                </label>
                                <div class="progress" style="height: 8px;">
                                    <div class="progress-bar bg-info" role="progressbar" style="width: 42%;" aria-valuenow="42" aria-valuemin="0" aria-valuemax="100"></div>
                                </div>
                            </div>
                        </div>
                        
                        <div class="col-md-6">
                            <h6 class="fw-semibold">Informații despre sistem</h6>
                            <table class="table table-sm table-borderless">
                                <tbody>
                                    <tr>
                                        <td class="text-muted">Versiune aplicație:</td>
                                        <td>0.0.1-SNAPSHOT</td>
                                    </tr>
                                    <tr>
                                        <td class="text-muted">Versiune Java:</td>
                                        <td>17.0.8</td>
                                    </tr>
                                    <tr>
                                        <td class="text-muted">Spring Boot:</td>
                                        <td>2.7.18</td>
                                    </tr>
                                    <tr>
                                        <td class="text-muted">Server:</td>
                                        <td>WebLogic 14.1.2</td>
                                    </tr>
                                    <tr>
                                        <td class="text-muted">Timp de funcționare:</td>
                                        <td>3 zile, 14 ore</td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
    <div class="row">
        <div class="col-12">
            <div class="card">
                <div class="card-header d-flex justify-content-between align-items-center">
                    <h5 class="card-title mb-0">Utilizatori recenți</h5>
                    <button class="btn btn-sm btn-outline-primary">
                        <i class="bi bi-person-plus me-1"></i> Adaugă utilizator
                    </button>
                </div>
                <div class="card-body">
                    <div class="table-responsive">
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th scope="col">#</th>
                                    <th scope="col">Nume</th>
                                    <th scope="col">Email</th>
                                    <th scope="col">Rol</th>
                                    <th scope="col">Status</th>
                                    <th scope="col">Acțiuni</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <th scope="row">1</th>
                                    <td>Administrator Sistem</td>
                                    <td>admin@example.com</td>
                                    <td>Administrator</td>
                                    <td><span class="badge bg-success">Activ</span></td>
                                    <td>
                                        <div class="btn-group btn-group-sm" role="group">
                                            <button type="button" class="btn btn-outline-secondary">
                                                <i class="bi bi-pencil"></i>
                                            </button>
                                            <button type="button" class="btn btn-outline-secondary">
                                                <i class="bi bi-trash"></i>
                                            </button>
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <th scope="row">2</th>
                                    <td>Ion Popescu</td>
                                    <td>ion@example.com</td>
                                    <td>Manager</td>
                                    <td><span class="badge bg-success">Activ</span></td>
                                    <td>
                                        <div class="btn-group btn-group-sm" role="group">
                                            <button type="button" class="btn btn-outline-secondary">
                                                <i class="bi bi-pencil"></i>
                                            </button>
                                            <button type="button" class="btn btn-outline-secondary">
                                                <i class="bi bi-trash"></i>
                                            </button>
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <th scope="row">3</th>
                                    <td>Maria Ionescu</td>
                                    <td>maria@example.com</td>
                                    <td>Utilizator</td>
                                    <td><span class="badge bg-success">Activ</span></td>
                                    <td>
                                        <div class="btn-group btn-group-sm" role="group">
                                            <button type="button" class="btn btn-outline-secondary">
                                                <i class="bi bi-pencil"></i>
                                            </button>
                                            <button type="button" class="btn btn-outline-secondary">
                                                <i class="bi bi-trash"></i>
                                            </button>
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <th scope="row">4</th>
                                    <td>Ana Dumitrescu</td>
                                    <td>ana@example.com</td>
                                    <td>Utilizator</td>
                                    <td><span class="badge bg-warning text-dark">Inactiv</span></td>
                                    <td>
                                        <div class="btn-group btn-group-sm" role="group">
                                            <button type="button" class="btn btn-outline-secondary">
                                                <i class="bi bi-pencil"></i>
                                            </button>
                                            <button type="button" class="btn btn-outline-secondary">
                                                <i class="bi bi-trash"></i>
                                            </button>
                                        </div>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
