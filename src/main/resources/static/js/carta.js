document.addEventListener('DOMContentLoaded', function () {
    // Variables globales
    let cart = JSON.parse(localStorage.getItem('cart')) || [];
    const cartIcon = document.querySelector('.content-shopping-cart');

    // Actualizar el ícono del carrito con la cantidad de items
    function updateCartIcon() {
        const totalItems = cart.reduce((total, item) => total + item.quantity, 0);
        cartIcon.textContent = totalItems > 0 ? totalItems : 0;
        cartIcon.style.display = totalItems > 0 ? 'flex' : 'none';
    }

    // Filtrar elementos del menú por categoría
    function filterMenu(category) {
        const menuSections = document.querySelectorAll('.menu-section');

        menuSections.forEach(section => {
            if (category === 'all' || section.dataset.category === category) {
                section.style.display = 'block';
            } else {
                section.style.display = 'none';
            }
        });
    }

    // Manejar clics en los botones de filtro
    const filterButtons = document.querySelectorAll('.filter-btn');
    filterButtons.forEach(button => {
        button.addEventListener('click', function () {
            // Remover la clase active de todos los botones
            filterButtons.forEach(btn => btn.classList.remove('active'));

            // Agregar la clase active al botón clickeado
            this.classList.add('active');

            // Filtrar el menú según la categoría seleccionada
            const category = this.dataset.category;
            filterMenu(category);
        });
    });

    // Agregar items al carrito
    function addToCart(itemName, itemPrice, itemImg) {
        // Buscar si el item ya está en el carrito
        const existingItem = cart.find(item => item.name === itemName);

        if (existingItem) {
            // Incrementar la cantidad si ya existe
            existingItem.quantity += 1;
        } else {
            // Agregar nuevo item al carrito
            cart.push({
                name: itemName,
                price: parseFloat(itemPrice.replace('S/ ', '')),
                img: itemImg,
                quantity: 1
            });
        }

        // Guardar en localStorage
        localStorage.setItem('cart', JSON.stringify(cart));

        // Actualizar el ícono del carrito
        updateCartIcon();

        // Mostrar notificación
        showNotification(`${itemName} añadido al carrito`);
    }

    // Mostrar notificación
    function showNotification(message) {
        const notification = document.createElement('div');
        notification.className = 'notification';
        notification.textContent = message;
        document.body.appendChild(notification);

        // Animación de entrada
        setTimeout(() => {
            notification.style.opacity = '1';
            notification.style.transform = 'translateY(0)';
        }, 10);

        // Eliminar después de 3 segundos
        setTimeout(() => {
            notification.style.opacity = '0';
            notification.style.transform = 'translateY(-100%)';
            setTimeout(() => {
                notification.remove();
            }, 300);
        }, 3000);
    }

    // Manejar clics en los botones "Añadir al carrito" para todos los productos
    document.addEventListener('click', function (e) {
        // Verificar si se hizo clic en un botón de añadir al carrito o en su icono
        const addToCartBtn = e.target.closest('.add-to-cart');

        if (addToCartBtn) {
            const menuItem = addToCartBtn.closest('.menu-item');
            const itemName = menuItem.querySelector('h5').textContent;
            const itemPrice = menuItem.querySelector('.texto-pri').textContent;
            const itemImg = menuItem.querySelector('.item-img')?.src || '';

            addToCart(itemName, itemPrice, itemImg);
        }
    });

    // Redirigir al carrito al hacer clic en el ícono
    document.querySelector('.cart-icon').addEventListener('click', function (e) {
        // Evitar que se ejecute si se hace clic directamente en el contador
        if (!e.target.classList.contains('content-shopping-cart')) {
            // Aquí puedes redirigir a la página del carrito cuando exista
            // window.location.href = 'carrito.html';

            // Por ahora mostramos un mensaje
            showNotification('Redirigiendo al carrito de compras...');
        }
    });

    // Inicializar
    updateCartIcon();

    // Estilos para la notificación (podrían moverse a CSS)
    const style = document.createElement('style');
    style.textContent = `
        .notification {
            position: fixed;
            top: 20px;
            right: 20px;
            background-color: #4CAF50;
            color: white;
            padding: 15px 25px;
            border-radius: 4px;
            box-shadow: 0 2px 10px rgba(0,0,0,0.2);
            z-index: 10000;
            opacity: 0;
            transform: translateY(-100%);
            transition: opacity 0.3s, transform 0.3s;
        }
    `;
    document.head.appendChild(style);
});