   var x = document.createElement("canvas");
        addEventListener('resize', resize);
        addEventListener('load', resize);

        function resize() {
            x.height = window.innerHeight;
            x.width = window.innerWidth;
            context.fillStyle = 'rgba(0,0,0)';
            context.fillRect(0, 0, x.width, x.height);
        }
        document.body.appendChild(x);
        var context = x.getContext("2d");
        var mouse = {
            x: undefined,
            y: undefined
        };
        addEventListener('click', Event => {
            mouse.x = Event.clientX;
            mouse.y = Event.clientY;
        });

        function draw(x, y, radius) {
            this.x = x;
            this.y = y;
            this.radius = radius;
            this.color = getRandomColor();
            this.velocity = 0.1;
            this.update = () => {
                this.radius += this.velocity;
                if (this.radius > 20)
                    this.radius = radius;
                this.draws();
            }
            this.draws = () => {
                context.beginPath();
                context.arc(this.x, this.y, this.radius, 0, Math.PI * 2, true);
                context.strokeStyle = this.color;
                context.stroke();
                //console.log("foo");
            }

        }

        function getRandomColor() {
            var letters = '0123456789ABCDEF';
            var color = '#';
            for (var i = 0; i < 6; i++) {
                color += letters[Math.floor(Math.random() * 16)];
            }
            return color;
        }

        function randomize(min, max) {
            return Math.random() * (max - min + 1) + min;

        }

        function init() {
            particle = [];
            for (let i = 0; i < 300; i++) {
                particle.push(new draw(randomize(0, window.innerWidth), randomize(0, window.innerHeight), randomize(.1, 0.01)));

            }

        }

        function animate() {
            requestAnimationFrame(animate);
            context.fillStyle = 'rgba(0,0,0,0.01)';
            context.fillRect(0, 0, window.innerWidth, window.innerHeight);
            particle.forEach(particle => {
                particle.update();
            });
        }

        init();
        console.log(particle);
        animate();
