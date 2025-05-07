@param gg.jte.Content content

<div class="container my-5">
    <div class="row">
        <div class="col-12">
            <h1 class="display-4 mb-4">Istoricul Modificărilor (Changelog)</h1>
            <p class="lead mb-5">Acest document reține toate modificările semnificative pentru fiecare versiune a aplicației.</p>
            
            <div class="changelog-container">
                <!-- Version 0.0.1-MVP -->
                <div class="card mb-4 border-left-primary">
                    <div class="card-header">
                        <h2 class="h4 m-0">Versiunea 0.0.1-MVP <span class="badge bg-primary ms-2">Actuală</span></h2>
                        <small class="text-muted">3 Mai 2025</small>
                    </div>
                    <div class="card-body">
                        <h3 class="h5 text-success"><i class="bi bi-plus-circle"></i> Funcționalități noi</h3>
                        <ul class="mb-3">
                            <li>Implementarea funcționalității de bază pentru aplicație</li>
                            <li>Adăugarea sistemului de autentificare și autorizare</li>
                            <li>Integrarea cu HTMX pentru interacțiuni dinamice</li>
                            <li>Implementarea interfeței utilizator cu Bootstrap 5</li>
                        </ul>
                        
                        <h3 class="h5 text-primary"><i class="bi bi-arrow-repeat"></i> Funcționalități modificate</h3>
                        <ul class="mb-3">
                            <li>Optimizarea procesului de încărcare a paginii dashboard</li>
                            <li>Restructurarea arhitecturii aplicației conform principiilor hexagonale</li>
                        </ul>
                        
                        <h3 class="h5 text-danger"><i class="bi bi-bug"></i> Remediere erori</h3>
                        <ul>
                            <li>Rezolvarea problemei de sesiune expirată la utilizări îndelungate</li>
                            <li>Corecția bug-ului legat de afișarea notificărilor în timp real</li>
                        </ul>
                    </div>
                </div>
                
                <!-- Version 0.0.0-ALPHA -->
                <div class="card mb-4">
                    <div class="card-header">
                        <h2 class="h4 m-0">Versiunea 0.0.0-ALPHA</h2>
                        <small class="text-muted">15 Aprilie 2025</small>
                    </div>
                    <div class="card-body">
                        <h3 class="h5 text-success"><i class="bi bi-plus-circle"></i> Adăugări</h3>
                        <ul class="mb-3">
                            <li>Crearea scheletului inițial al aplicației</li>
                            <li>Configurarea mediului de dezvoltare Spring Boot</li>
                            <li>Integrarea JTE (Java Template Engine) pentru rendering</li>
                            <li>Setarea structurii bazei de date și migrările inițiale</li>
                        </ul>
                    </div>
                </div>
                
                <!-- Template pentru versiuni viitoare -->
                <!-- 
                <div class="card mb-4">
                    <div class="card-header bg-light">
                        <h2 class="h4 m-0">Versiunea X.Y.Z</h2>
                        <small class="text-muted">Data Lansării</small>
                    </div>
                    <div class="card-body">
                        <h3 class="h5 text-success"><i class="bi bi-plus-circle"></i> Adăugări</h3>
                        <ul class="mb-3">
                            <li>Descrierea adăugării</li>
                        </ul>
                        
                        <h3 class="h5 text-primary"><i class="bi bi-arrow-repeat"></i> Modificări</h3>
                        <ul class="mb-3">
                            <li>Descrierea modificării</li>
                        </ul>
                        
                        <h3 class="h5 text-danger"><i class="bi bi-bug"></i> Rezolvări de erori</h3>
                        <ul>
                            <li>Descrierea rezolvării</li>
                        </ul>
                    </div>
                </div>
                -->
            </div>
            
            <div class="text-center mt-5">
                <p><small class="text-muted">Acest changelog este actualizat odată cu fiecare lansare nouă a aplicației.</small></p>
            </div>
        </div>
    </div>
</div>

<style>
    .changelog-container .card {
        border-left: 4px solid #e9ecef;
        transition: all 0.2s ease;
    }
    
    .changelog-container .card:hover {
        box-shadow: 0 0.5rem 1rem rgba(0, 0, 0, 0.15);
    }
    
    .border-left-primary {
        border-left: 4px solid #4e73df !important;
    }
    
    .changelog-container h3 {
        margin-top: 1.5rem;
        font-weight: 600;
    }
    
    .changelog-container ul {
        padding-left: 1.5rem;
    }
    
    .changelog-container li {
        margin-bottom: 0.5rem;
    }
</style>
