document.addEventListener('DOMContentLoaded', function () {
    // Configuración de fecha mínima (hoy)
    const today = new Date();
    const dd = String(today.getDate()).padStart(2, '0');
    const mm = String(today.getMonth() + 1).padStart(2, '0');
    const yyyy = today.getFullYear();
    const minDate = yyyy + '-' + mm + '-' + dd;

    document.getElementById('reservation-date').min = minDate;

    // Configuración de horas disponibles
    const timeInput = document.getElementById('reservation-time');
    timeInput.addEventListener('focus', function () {
        this.type = 'time';
        this.step = '1800'; // Intervalos de 30 minutos
    });

    // Manejo del formulario
    const reservationForm = document.getElementById('reservationForm');

    reservationForm.addEventListener('submit', function (e) {
        e.preventDefault();

        // Validación básica
        const name = document.getElementById('reservation-name').value;
        const email = document.getElementById('reservation-email').value;
        const phone = document.getElementById('reservation-phone').value;
        const date = document.getElementById('reservation-date').value;
        const time = document.getElementById('reservation-time').value;
        const guests = document.getElementById('reservation-guests').value;

        if (!name || !email || !phone || !date || !time || !guests) {
            showNotification('Por favor complete todos los campos requeridos', 'error');
            return;
        }

        // Simular envío de reserva
        setTimeout(() => {
            showNotification('Reserva enviada con éxito. Nos pondremos en contacto para confirmar.', 'success');
            reservationForm.reset();

            // Redirigir después de 3 segundos (opcional)
            // setTimeout(() => {
            //     window.location.href = 'index.html';
            // }, 3000);
        }, 1500);
    });

    // Función para mostrar notificaciones
    function showNotification(message, type = 'success') {
        const notification = document.createElement('div');
        notification.className = `notification ${type}`;
        notification.innerHTML = `
            <i class="fa-solid ${type === 'success' ? 'fa-circle-check' : 'fa-circle-exclamation'}"></i>
            <span>${message}</span>
        `;
        document.body.appendChild(notification);

        // Mostrar
        setTimeout(() => {
            notification.style.opacity = '1';
            notification.style.bottom = '20px';
        }, 10);

        // Ocultar después de 5 segundos
        setTimeout(() => {
            notification.style.opacity = '0';
            notification.style.bottom = '-50px';
            setTimeout(() => {
                notification.remove();
            }, 500);
        }, 5000);
    }

    // Agregar estilos para las notificaciones
    const style = document.createElement('style');
    style.textContent = `
        .notification {
            position: fixed;
            bottom: -50px;
            left: 50%;
            transform: translateX(-50%);
            background-color: var(--primary-color);
            color: white;
            padding: 1.5rem 2.5rem;
            border-radius: 50px;
            box-shadow: 0 5px 15px rgba(0,0,0,0.2);
            z-index: 1000;
            opacity: 0;
            transition: all 0.3s ease;
            display: flex;
            align-items: center;
            gap: 1.5rem;
            font-size: 1.4rem;
            max-width: 90%;
        }
        
        .notification.success {
            background-color: #4CAF50;
        }
        
        .notification.error {
            background-color: #F44336;
        }
        
        .notification i {
            font-size: 1.8rem;
        }
    `;
    document.head.appendChild(style);
});