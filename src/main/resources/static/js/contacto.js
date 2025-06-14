document.addEventListener('DOMContentLoaded', function () {
    // FAQ Accordion
    const faqQuestions = document.querySelectorAll('.faq-question');

    faqQuestions.forEach(question => {
        question.addEventListener('click', function () {
            const faqItem = this.parentElement;
            const isActive = faqItem.classList.contains('active');

            // Cerrar todos los items primero
            document.querySelectorAll('.faq-item').forEach(item => {
                item.classList.remove('active');
            });

            // Abrir el clickeado si no estaba activo
            if (!isActive) {
                faqItem.classList.add('active');
            }
        });
    });

    // Form Validation
    const contactForm = document.getElementById('contactForm');

    contactForm.addEventListener('submit', function (e) {
        e.preventDefault();

        // Validación básica
        const name = document.getElementById('contact-name').value;
        const email = document.getElementById('contact-email').value;
        const subject = document.getElementById('contact-subject').value;
        const message = document.getElementById('contact-message').value;

        if (!name || !email || !subject || !message) {
            showNotification('Por favor complete todos los campos requeridos', 'error');
            return;
        }

        // Simular envío
        setTimeout(() => {
            showNotification('Mensaje enviado con éxito. Nos pondremos en contacto pronto.', 'success');
            contactForm.reset();
        }, 1500);
    });

    // Notification Function
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

    // Inyectar estilos para notificaciones
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