class LoginForm {
    constructor(formId) {
        this.form = document.getElementById(formId);
        this.emailInput = this.form.querySelector('input[type="email"]');
        this.passwordInput = this.form.querySelector('input[type="password"]');
        this.toggleBtn = this.form.querySelector('.toggle-password');
        this.messageBox = this.form.querySelector('.form-message');

        this.init();
    }

    init() {
        this.form.addEventListener('submit', (e) => this.handleSubmit(e));
        if (this.toggleBtn) {
            this.toggleBtn.addEventListener('click', () => this.togglePasswordVisibility());
        }
    }

    togglePasswordVisibility() {
        const type = this.passwordInput.getAttribute('type');
        this.passwordInput.setAttribute(
            'type',
            type === 'password' ? 'text' : 'password'
        );
        this.toggleBtn.textContent = type === 'password' ? '🙈' : '👁️';
    }

    handleSubmit(e) {
        e.preventDefault();
        const email = this.emailInput.value.trim();
        const password = this.passwordInput.value.trim();

        if (!email || !password) {
            this.showMessage('Por favor completa todos los campos.', 'error');
            return;
        }

        if (!this.validateEmail(email)) {
            this.showMessage('Ingresa un correo válido.', 'error');
            return;
        }

        this.showMessage('¡Inicio de sesión exitoso!', 'success');
    }

    validateEmail(email) {
        const re = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        return re.test(email.toLowerCase());
    }

    showMessage(message, type = 'error') {
        if (!this.messageBox) {
            this.messageBox = document.createElement('div');
            this.messageBox.classList.add('form-message');
            this.form.prepend(this.messageBox);
        }

        this.messageBox.textContent = message;
        this.messageBox.style.color = type === 'error' ? 'red' : 'green';
        this.messageBox.style.marginBottom = '1rem';
        this.messageBox.style.fontWeight = 'bold';
    }
}

document.addEventListener('DOMContentLoaded', () => {
    new LoginForm('login-form');
});
