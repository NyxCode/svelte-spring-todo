<script>
    import {onMount} from 'svelte';
    import Todo from "./Todo.svelte";

    let todos = [];
    let content = "Enter new Todo";

    onMount(reloadTodos)

    async function reloadTodos() {
        todos = await fetch("/api/todos").then(response => response.json());
    }

    async function createTodo() {
        await fetch(
            "/api/todos",
            {
                method: "POST",
                body: content
            });
        await reloadTodos();
    }
</script>

<input bind:value={content}>
<button on:click={createTodo}>Create new Todo</button>

{#each todos as todo}
    <Todo todo="{todo}" on:reload={reloadTodos}/>
{/each}