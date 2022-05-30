<script>
    import {createEventDispatcher} from "svelte";

    export let todo;

    const dispatch = createEventDispatcher();

    async function deleteTodo() {
        await fetch("/api/todos/" + todo.id, { method: "DELETE" });
        dispatch("reload");
    }
</script>

<div>
    Nr. {todo.id}: {todo.content}
    <button on:click={deleteTodo}>Delete</button>
</div>