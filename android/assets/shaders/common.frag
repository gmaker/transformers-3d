#ifdef GL_ES
    precision mediump float;
#endif

uniform sampler2D u_texture;
uniform sampler2D u_dithering;
uniform vec3 u_fogColor;

varying vec4 v_col;
varying vec2 v_uv;
varying float v_br;
varying vec4 v_pos;

void main() {
	vec4 col = texture2D(u_texture, v_uv);
	if (col.a < 0.9) discard;

	float br = clamp(4.0 / abs(v_pos.z) * 4.0 - 0.1, 0.0, 1.0);

	float dither = texture2D(u_dithering, mod(gl_FragCoord.xy / 2.0, 4.0) / 4.0).a * 16.0;
	if (br < dither) {
		br *= 0.61;
	}

	col = vec4(v_col.rgb * col.rgb * br + (1.0 - br) * u_fogColor, v_col.a);
	gl_FragColor = col;
}