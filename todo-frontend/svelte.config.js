import adapter from '@sveltejs/adapter-auto';

/** @type {import('@sveltejs/kit').Config} */
const config = {
	kit: {
		adapter: adapter(),
		vite: {
			server: {
				proxy: {
					'/api': {
						target: 'http://localhost:8080',
						changeOrigin: true,
						rewrite: (path) => path.replace(/^\/api/, '')
					},
				}
			}
		}
	}
};

export default config;
