@param String contextPath

<!-- Partial pentru Căutare -->
<div class="container-fluid py-3">
    <h2 class="mb-4">Căutare</h2>
    
    <div class="row mb-4">
        <div class="col-12">
            <div class="card">
                <div class="card-body">
                    <form class="row g-3">
                        <div class="col-md-6">
                            <div class="input-group">
                                <input type="text" class="form-control" placeholder="Introduceți termenii de căutare..." aria-label="Termeni de căutare">
                                <button class="btn btn-primary" type="button">
                                    <i class="bi bi-search me-1"></i> Caută
                                </button>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <select class="form-select" aria-label="Categorie de căutare">
                                <option selected>Toate categoriile</option>
                                <option value="1">Documente</option>
                                <option value="2">Utilizatori</option>
                                <option value="3">Rapoarte</option>
                                <option value="4">Setări</option>
                            </select>
                        </div>
                        <div class="col-md-2">
                            <button type="button" class="btn btn-outline-secondary w-100" data-bs-toggle="modal" data-bs-target="#searchOptionsModal">
                                <i class="bi bi-sliders me-1"></i> Opțiuni
                            </button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    
    <div class="row">
        <div class="col-12">
            <div class="card">
                <div class="card-header">
                    <h5 class="card-title mb-0">Rezultate căutare</h5>
                </div>
                <div class="card-body">
                    <p class="text-muted text-center py-5">
                        <i class="bi bi-search fs-1 d-block mb-3"></i>
                        Introduceți termenii de căutare pentru a afișa rezultate
                    </p>
                </div>
            </div>
        </div>
    </div>
    
    <!-- Modal pentru opțiuni avansate de căutare -->
    <div class="modal fade" id="searchOptionsModal" tabindex="-1" aria-labelledby="searchOptionsModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="searchOptionsModalLabel">Opțiuni avansate de căutare</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <div class="mb-3">
                        <label class="form-label">Interval de timp</label>
                        <div class="row g-2">
                            <div class="col">
                                <input type="date" class="form-control" placeholder="Data început">
                            </div>
                            <div class="col">
                                <input type="date" class="form-control" placeholder="Data sfârșit">
                            </div>
                        </div>
                    </div>
                    
                    <div class="mb-3">
                        <label class="form-label">Filtrare după status</label>
                        <div class="form-check">
                            <input class="form-check-input" type="checkbox" value="" id="statusActive" checked>
                            <label class="form-check-label" for="statusActive">
                                Active
                            </label>
                        </div>
                        <div class="form-check">
                            <input class="form-check-input" type="checkbox" value="" id="statusInactive" checked>
                            <label class="form-check-label" for="statusInactive">
                                Inactive
                            </label>
                        </div>
                        <div class="form-check">
                            <input class="form-check-input" type="checkbox" value="" id="statusArchived">
                            <label class="form-check-label" for="statusArchived">
                                Arhivate
                            </label>
                        </div>
                    </div>
                    
                    <div class="mb-3">
                        <label class="form-label">Sortare</label>
                        <select class="form-select">
                            <option value="relevance">După relevanță</option>
                            <option value="newest">Cele mai noi</option>
                            <option value="oldest">Cele mai vechi</option>
                            <option value="name">După nume</option>
                        </select>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Închide</button>
                    <button type="button" class="btn btn-primary">Aplică filtru</button>
                </div>
            </div>
        </div>
    </div>
</div>
