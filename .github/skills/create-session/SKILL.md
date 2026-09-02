# Crear una sesión

Sigue este procedimiento cuando una issue solicite crear una sesión docente.
La issue define el alcance pedagógico concreto y prevalece sobre cualquier
suposición.

## 1. Leer el contexto

Antes de modificar archivos:

1. Lee `AGENTS.md`.
2. Lee el `README.md` raíz.
3. Lee completa la issue asignada.
4. Revisa el README de la sesión inmediatamente anterior, si existe.
5. Revisa cualquier sesión anterior que la issue cite explícitamente.

No es necesario leer todas las sesiones existentes salvo que sea relevante.

## 2. Determinar el alcance

Extrae de la issue el número y título de sesión, duración si se indica,
objetivos, conceptos nuevos, conocimientos previos, ejemplos de clase,
ejercicios, tarea para casa y restricciones pedagógicas.

No añadas conceptos principales que no se hayan solicitado.

## 3. Crear el directorio

Comprueba primero si existe `sessions/session-XX/` —con `XX` como número de dos
dígitos—. Si existe, revisa todos sus archivos antes de crear o modificar
contenido. El código y los recursos ya presentes forman parte del material real
utilizado o preparado para clase: no los elimines, renombres ni reescribas salvo
que la issue lo solicite expresamente.

La existencia previa del directorio no implica que la sesión esté terminada.
Completa únicamente lo solicitado en la issue. Si no existe, créalo junto con,
como mínimo, `sessions/session-XX/README.md`. Crea `examples/`, `exercises/` o
`assets/` dentro de la sesión solo cuando haya contenido que justifique esos
directorios.

## 4. Generar el README de sesión

Como referencia, puede incluir:

```markdown
# Sesión XX — Título
## Objetivos
## Antes de empezar
## Conceptos
## Desarrollo de la sesión
## Ejemplo trabajado en clase
## Experimenta
## Ejercicios
## Tarea para casa
## Qué deberías llevarte de esta sesión
```

Adapta la estructura a cada sesión y no incluyas secciones vacías.

Cuando existan ejemplos o recursos previos, genera el README de forma coherente
con ellos y enlaza los ejemplos relevantes.

## 5. Añadir ejemplos de código

Cuando haya código, utiliza Java y ejemplos pequeños con nombres claros. Evita
conceptos aún no introducidos, prefiere ejemplos que permitan experimentar y
explica qué pretende enseñar cada fragmento.

Si hay código suficiente para archivos independientes, guárdalo en
`sessions/session-XX/examples/` y enlázalo desde el README.

Explica el código existente respetando su nivel y decisiones pedagógicas, aunque
pudiera escribirse de una forma más avanzada o idiomática. Si contiene conceptos
aún no introducidos formalmente, describe solo lo que la issue indique trabajar;
no conviertas detalles accidentales del código en contenidos docentes nuevos ni
sustituyas automáticamente el código del profesor.

## 6. Plantear ejercicios

Distingue claramente las actividades realizadas o propuestas durante la sesión,
los ejercicios de práctica y la tarea para casa. No incluyas automáticamente
soluciones completas de ejercicios destinados al alumnado, salvo que la issue
lo solicite.

## 7. Actualizar el índice

Después de crear la sesión, añade una entrada al índice de `README.md`, por
ejemplo:

```markdown
| 01 | Introducción a la POO | [Sesión 01](sessions/session-01/) |
```

No modifiques otras entradas salvo que sea necesario reparar un enlace.

## 8. Revisión final

Comprueba que:

- el número de sesión es correcto;
- todos los enlaces relativos funcionan;
- no hay secciones vacías;
- no se han adelantado contenidos futuros;
- los ejemplos coinciden con lo solicitado en la issue;
- el README raíz incluye la nueva sesión;
- no se han modificado innecesariamente sesiones anteriores.
- el contenido previo de la sesión, si existía, se ha preservado y se refleja
  correctamente en el README.
