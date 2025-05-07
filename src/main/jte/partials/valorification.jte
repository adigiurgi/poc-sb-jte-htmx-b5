@param String contextPath

<!-- Partial pentru Valorificare -->
<div class="container-fluid py-3">
    <h2 class="mb-4">Valorificare</h2>
    
    <div class="row mb-4">
        <div class="col-md-4 mb-4">
            <div class="card h-100">
                <div class="card-header">
                    <h5 class="card-title mb-0">SVG Loaders Examples</h5>
                </div>
                <div class="card-body">
                    <p class="mb-2">Avem aici mai multe svg loaders cu dimensiuni intre 1KB si 3KB:</p>
                    <div class="container my-5">
                        <div class="row row-cols-6 g-5">
                            <div class="col">
                                <img src="${contextPath}/static/svg-loaders/audio.svg" alt="Audio Loader" width="40" height="40">
                            </div>
                            <div class="col">
                                <img src="${contextPath}/static/svg-loaders/ball-triangle.svg" alt="Ball Triangle Loader" width="40" height="40">
                            </div>
                            <div class="col">
                                <img src="${contextPath}/static/svg-loaders/bars.svg" alt="Bars Loader" width="40" height="40">
                            </div>
                            <div class="col">
                                <img src="${contextPath}/static/svg-loaders/circles.svg" alt="Circles Loader" width="40" height="40">
                            </div>
                            <div class="col">
                                <img src="${contextPath}/static/svg-loaders/grid.svg" alt="Grid Loader" width="40" height="40">
                            </div>
                            <div class="col">
                                <img src="${contextPath}/static/svg-loaders/hearts.svg" alt="Hearts Loader" width="40" height="40">
                            </div>
                            <div class="col">
                                <img src="${contextPath}/static/svg-loaders/oval.svg" alt="Hearts Loader" width="40" height="40">
                            </div>
                            <div class="col">
                                <img src="${contextPath}/static/svg-loaders/puff.svg" alt="Puff Loader" width="40" height="40">
                            </div>
                            <div class="col">
                                <img src="${contextPath}/static/svg-loaders/rings.svg" alt="Rings Loader" width="40" height="40">
                            </div>
                            <div class="col">
                                <img src="${contextPath}/static/svg-loaders/spinning-circles.svg" alt="Spinning Circles Loader" width="40" height="40">
                            </div>
                            <div class="col">
                                <img src="${contextPath}/static/svg-loaders/tail-spin.svg" alt="Puff Loader" width="40" height="40">
                            </div>
                            <div class="col">
                                <img src="${contextPath}/static/svg-loaders/three-dots.svg" alt="Puff Loader" width="40" height="40">
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>
        <div class="col-md-4 mb-4 mb-md-0">
            <div class="card h-100">
                <div class="card-header">
                    <h5 class="card-title mb-0">Statistici generale</h5>
                </div>
                <div class="card-body">
                    <div class="row text-center">
                        <div class="col-6 mb-4">
                            <h3 class="fw-bold text-primary">385</h3>
                            <div class="text-muted small">Total documente</div>
                        </div>
                        <div class="col-6 mb-4">
                            <h3 class="fw-bold text-success">64</h3>
                            <div class="text-muted small">Documente active</div>
                        </div>
                        <div class="col-6">
                            <h3 class="fw-bold text-info">42</h3>
                            <div class="text-muted small">Utilizatori activi</div>
                        </div>
                        <div class="col-6">
                            <h3 class="fw-bold text-warning">12</h3>
                            <div class="text-muted small">Rapoarte generate</div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        
        <div class="col-md-4">
            <div class="card h-100">
                <div class="card-header">
                    <h5 class="card-title mb-0">Activitate recentă</h5>
                </div>
                <div class="card-body p-0">
                    <div class="list-group list-group-flush">
                        <div class="list-group-item d-flex justify-content-between align-items-center">
                            <div>
                                <strong>Document actualizat</strong>
                                <div class="small text-muted">Specificație tehnică actualizată</div>
                            </div>
                            <span class="badge bg-primary">acum 30 min</span>
                        </div>
                        <div class="list-group-item d-flex justify-content-between align-items-center">
                            <div>
                                <strong>Raport generat</strong>
                                <div class="small text-muted">Raport lunar de activitate</div>
                            </div>
                            <span class="badge bg-primary">acum 2 ore</span>
                        </div>
                        <div class="list-group-item d-flex justify-content-between align-items-center">
                            <div>
                                <strong>Utilizator nou</strong>
                                <div class="small text-muted">Maria Popescu a fost adăugată</div>
                            </div>
                            <span class="badge bg-primary">acum 1 zi</span>
                        </div>
                        <div class="list-group-item d-flex justify-content-between align-items-center">
                            <div>
                                <strong>Document șters</strong>
                                <div class="small text-muted">Documentație veche eliminată</div>
                            </div>
                            <span class="badge bg-primary">acum 2 zile</span>
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
                    <h5 class="card-title mb-0">Grafic activitate</h5>
                    <div class="btn-group" role="group">
                        <button type="button" class="btn btn-sm btn-outline-secondary">Săptămânal</button>
                        <button type="button" class="btn btn-sm btn-outline-secondary active">Lunar</button>
                        <button type="button" class="btn btn-sm btn-outline-secondary">Anual</button>
                    </div>
                </div>
                <div class="card-body">
                    <div class="text-center py-5 text-muted">
                        <i class="bi bi-graph-up fs-1 d-block mb-3"></i>
                        <p>Graficul de activitate va fi afișat aici.<br>Integrați o bibliotecă de grafice pentru vizualizare.</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
