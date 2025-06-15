// Función para mostrar modal de confirmación
function mostrarModalConfirmacion(evento) {
    // Prevenir el envío automático del formulario
    evento.preventDefault();
    
    // Obtener información del formulario para personalizar el mensaje
    const formulario = evento.target;
    const accion = formulario.action;
    let tipoElemento = 'elemento';
    let mensaje = '¿Estás seguro de que deseas realizar esta acción?';
    
    // Detectar automáticamente el tipo de elemento basándose en la URL
    if (accion.includes('eliminar')) {
        if (accion.includes('Cliente') || accion.includes('cliente')) {
            tipoElemento = 'cliente';
        } else if (accion.includes('Producto') || accion.includes('producto')) {
            tipoElemento = 'producto';
        } else if (accion.includes('Usuario') || accion.includes('usuario')) {
            tipoElemento = 'usuario';
        } else if (accion.includes('Categoria') || accion.includes('categoria')) {
            tipoElemento = 'categoría';
        } else if (accion.includes('Cliente') || accion.includes('cliente')) {
            tipoElemento = 'proveedor';
        } else if (accion.includes('Pedido') || accion.includes('pedido')) {
            tipoElemento = 'venta';
        } 
        mensaje = `¿Estás seguro de que deseas eliminar este ${tipoElemento}?`;
    }
    
    // Verificar si hay un mensaje personalizado en el botón
    const boton = evento.submitter;
    if (boton && boton.dataset.mensaje) {
        mensaje = boton.dataset.mensaje;
    }
    
    // Crear el modal
    const modal = document.createElement('div');
    modal.className = 'modal-overlay';
    modal.innerHTML = `
        <div class="modal-content">
            <div class="modal-header">
                <h3>⚠️ Confirmar Acción</h3>
            </div>
            <div class="modal-body">
                <p>${mensaje}</p>
                <p><strong>Esta acción no se puede deshacer.</strong></p>
            </div>
            <div class="modal-footer">
                <button class="btn btn-secondary" onclick="cerrarModal()">Cancelar</button>
                <button class="btn btn-danger" onclick="confirmarAccion()">Confirmar</button>
            </div>
        </div>
    `;
    
    // Agregar el modal al body
    document.body.appendChild(modal);
    
    // Guardar referencia al formulario que se va a enviar
    window.formularioConfirmar = formulario;
    
    // Aplicar estilos CSS
    aplicarEstilos();
}

// Función para cerrar el modal
function cerrarModal() {
    const modal = document.querySelector('.modal-overlay');
    if (modal) {
        modal.remove();
    }
    // Limpiar la referencia al formulario
    window.formularioConfirmar = null;
}

// Función para confirmar la acción
function confirmarAccion() {
    if (window.formularioConfirmar) {
        window.formularioConfirmar.submit();
    }
    cerrarModal();
}

// Función para aplicar estilos CSS al modal
function aplicarEstilos() {
    // Verificar si ya existen los estilos
    if (document.getElementById('modal-styles')) {
        return;
    }
    
    const styles = document.createElement('style');
    styles.id = 'modal-styles';
    styles.textContent = `
        .modal-overlay {
            position: fixed;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            background-color: rgba(0, 0, 0, 0.5);
            display: flex;
            justify-content: center;
            align-items: center;
            z-index: 1000;
            animation: fadeIn 0.3s ease;
        }
        
        .modal-content {
            background: white;
            border-radius: 8px;
            box-shadow: 0 4px 20px rgba(0, 0, 0, 0.3);
            max-width: 450px;
            width: 90%;
            animation: slideIn 0.3s ease;
        }
        
        .modal-header {
            padding: 20px 20px 10px;
            border-bottom: 1px solid #eee;
        }
        
        .modal-header h3 {
            margin: 0;
            color: #d32f2f;
            font-size: 1.2em;
        }
        
        .modal-body {
            padding: 20px;
        }
        
        .modal-body p {
            margin: 10px 0;
            color: #333;
            line-height: 1.5;
        }
        
        .modal-footer {
            padding: 10px 20px 20px;
            display: flex;
            justify-content: flex-end;
            gap: 10px;
        }
        
        .btn {
            padding: 8px 16px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 14px;
            transition: all 0.3s ease;
            font-weight: 500;
        }
        
        .btn-secondary {
            background-color: #6c757d;
            color: white;
        }
        
        .btn-secondary:hover {
            background-color: #5a6268;
            transform: translateY(-1px);
        }
        
        .btn-danger {
            background-color: #dc3545;
            color: white;
        }
        
        .btn-danger:hover {
            background-color: #c82333;
            transform: translateY(-1px);
        }
        
        @keyframes fadeIn {
            from { opacity: 0; }
            to { opacity: 1; }
        }
        
        @keyframes slideIn {
            from { 
                opacity: 0;
                transform: translateY(-50px) scale(0.9);
            }
            to { 
                opacity: 1;
                transform: translateY(0) scale(1);
            }
        }
    `;
    
    document.head.appendChild(styles);
}

// Inicializar cuando el DOM esté listo
document.addEventListener('DOMContentLoaded', function() {
    // Buscar todos los formularios que necesiten confirmación
    // Puede ser por clase CSS o por atributo data
    const formulariosConfirmar = document.querySelectorAll(
        'form[data-confirm="true"], ' +
        'form.confirm-form, ' +
        'form[action*="eliminar"], ' +
        'form[action*="delete"], ' +
        'form[action*="borrar"]'
    );
    
    formulariosConfirmar.forEach(formulario => {
        formulario.addEventListener('submit', mostrarModalConfirmacion);
    });
    
    // También detectar botones dentro de formularios que tengan data-confirm
    const botonesConfirmar = document.querySelectorAll('button[data-confirm="true"]');
    botonesConfirmar.forEach(boton => {
        const formulario = boton.closest('form');
        if (formulario) {
            formulario.addEventListener('submit', mostrarModalConfirmacion);
        }
    });
});

// Cerrar modal con tecla Escape
document.addEventListener('keydown', function(evento) {
    if (evento.key === 'Escape') {
        cerrarModal();
    }
});

// Cerrar modal al hacer click fuera de él
document.addEventListener('click', function(evento) {
    if (evento.target.classList.contains('modal-overlay')) {
        cerrarModal();
    }
});

// Función para inicializar formularios dinámicamente (útil para contenido cargado por AJAX)
function inicializarConfirmacion(contenedor = document) {
    const formulariosConfirmar = contenedor.querySelectorAll(
        'form[data-confirm="true"], ' +
        'form.confirm-form, ' +
        'form[action*="eliminar"], ' +
        'form[action*="delete"], ' +
        'form[action*="borrar"]'
    );
    
    formulariosConfirmar.forEach(formulario => {
        // Remover event listener previo si existe
        formulario.removeEventListener('submit', mostrarModalConfirmacion);
        // Agregar el nuevo event listener
        formulario.addEventListener('submit', mostrarModalConfirmacion);
    });
}